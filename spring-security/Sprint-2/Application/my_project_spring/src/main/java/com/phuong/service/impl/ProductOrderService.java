package com.phuong.service.impl;

import com.phuong.dto.ErrorDto;
import com.phuong.dto.PaymentDto;
import com.phuong.model.Bill;
import com.phuong.model.Customer;
import com.phuong.model.Product;
import com.phuong.model.ProductOrder;
import com.phuong.repository.IBillRepository;
import com.phuong.repository.IProductOrderRepository;
import com.phuong.repository.IProductRepository;
import com.phuong.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class ProductOrderService implements IProductOrderService {
    @Autowired
    private IProductOrderRepository productOrderRepository;

    @Autowired
    private IBillRepository billRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public ErrorDto saveOrder(ProductOrder productOrder) {
        ErrorDto errorDto = new ErrorDto();
        productOrder.setIsDeleted(false);
        ProductOrder po = this.productOrderRepository.findProductOrderListByCustomerAndProduct(productOrder);
        if (po == null) {
            if (productOrder.getQuantity() > productOrder.getProduct().getQuantity()) {
                errorDto.setMessage("quantity");
                errorDto.setProductOrder(po);
                return errorDto;
            } else {
                this.productOrderRepository.save(productOrder);
            }
        } else {
            if ((po.getQuantity() + productOrder.getQuantity()) > productOrder.getProduct().getQuantity()) {
                errorDto.setMessage("quantity");
                errorDto.setProductOrder(po);
                return errorDto;
            } else {
                po.setQuantity(productOrder.getQuantity() + po.getQuantity());
                this.productOrderRepository.save(po);
            }
        }
        return errorDto;
    }

    @Override
    public List<ProductOrder> getProductInCardByCustomer(Customer customer) {
        return this.productOrderRepository.getProductInCardByCustomer(customer);
    }

    @Override
    public Boolean minusQuantity(ProductOrder productOrder) {
        if (productOrder.getQuantity() > 1) {
            productOrder.setQuantity(productOrder.getQuantity() - 1);
            this.productOrderRepository.save(productOrder);
            return true;
        }
        return false;
    }

    @Override
    public Boolean plusQuantity(ProductOrder productOrder) {
        if (productOrder.getQuantity() < productOrder.getProduct().getQuantity()) {
            productOrder.setQuantity(productOrder.getQuantity() + 1);
            this.productOrderRepository.save(productOrder);
            return true;
        }
        return false;
    }

    @Override
    public Boolean findProductOrder(ProductOrder productOrder) {
        ProductOrder po = this.productOrderRepository.findById(productOrder.getId()).orElse(null);
        if (po != null) {
            this.productOrderRepository.delete(productOrder);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public PaymentDto goPayment(Customer customer) {
        List<ProductOrder> productOrderList = this.productOrderRepository.getProductInCardByCustomer(customer);
        List<Bill> billList = this.billRepository.findAll();
        int randomCode = this.getRandomNumber(billList);
        Bill bill = new Bill();
        bill.setCode(String.valueOf(randomCode));
        bill.setProductOrderList(productOrderList);
        bill.setIsDeleted(false);
        bill.setCreationDate(new Date(System.currentTimeMillis()));
        this.billRepository.save(bill);
        Bill billReturn = this.billRepository.getBillByCode(randomCode);
        this.productOrderRepository.setBill(customer.getId(), billReturn.getId());
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setBill(billReturn);
        paymentDto.setProductOrderList(productOrderList);
        paymentDto.setCustomer(customer);
        for (ProductOrder productOrder: productOrderList) {
            this.productRepository.updateQuantity(productOrder.getQuantity(), productOrder.getProduct().getId());
            Product product = this.productRepository.getById(productOrder.getProduct().getId());
            if (product.getQuantity() <= 1) {
                    this.productRepository.updateIsDeleted(product.getId());
                }
        }
        return paymentDto;
    }

    @Override
    public Page<ProductOrder> findProductOrderByUserName(Pageable pageable, Customer customer) {
        return this.productOrderRepository.findProductOrderByCustomer(pageable, customer);
    }

    private int getRandomNumber(List<Bill> billList) {
        int randomNumber = 10000;
        while (checkExists(billList, randomNumber)) {
            randomNumber = (int) ( (Math.random() * 89999) + 10001);
        }
        return randomNumber;
    }

    private boolean checkExists(List<Bill> billList, int randomNumber) {
        for (Bill bill : billList) {
            if (Integer.parseInt(bill.getCode()) == randomNumber) {
                return true;
            }
        }
        return false;
    }
}
