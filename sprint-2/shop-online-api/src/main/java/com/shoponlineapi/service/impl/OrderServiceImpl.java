package com.shoponlineapi.service.impl;

import com.shoponlineapi.dto.ErrorDTO;
import com.shoponlineapi.model.Customer;
import com.shoponlineapi.model.OrderService;
import com.shoponlineapi.repository.ICustomerRepository;
import com.shoponlineapi.repository.IOrderServiceRepository;
import com.shoponlineapi.repository.IProductRepository;
import com.shoponlineapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderServiceRepository iOrderServiceRepository;
    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public ErrorDTO saveOrder(OrderService orderService) {
        ErrorDTO errorDto = new ErrorDTO();
        orderService.setIsDeleted(false);
        orderService.setCreationDate(Date.valueOf(LocalDate.now()));
        OrderService os = this.iOrderServiceRepository.findProductOrderListByCustomerAndProduct(orderService);
        if (os == null) {
            if (orderService.getQuantity() > orderService.getProduct().getQuantity()) {
                errorDto.setMessage("quantity");
                errorDto.setOrderService(os);
                return errorDto;
            } else {
                this.iOrderServiceRepository.save(orderService);
            }
        } else {
            if ((os.getQuantity() + orderService.getQuantity()) > orderService.getProduct().getQuantity()) {
                errorDto.setMessage("quantity");
                errorDto.setOrderService(os);
                return errorDto;
            } else {
                os.setQuantity(orderService.getQuantity() + os.getQuantity());
                this.iOrderServiceRepository.save(os);
            }
        }
        return errorDto;
    }

    @Override
    public List<OrderService> getProductInCardByCustomer(Customer customer) {
        return this.iOrderServiceRepository.getProductInCardByCustomer(customer);
    }

    @Override
    public Boolean minusQuantity(OrderService orderService) {
        if (orderService.getQuantity() > 1) {
            orderService.setQuantity(orderService.getQuantity() - 1);
            this.iOrderServiceRepository.save(orderService);
            return true;
        }
        return false;
    }

    @Override
    public Boolean plusQuantity(OrderService orderService) {
        if (orderService.getQuantity() < orderService.getProduct().getQuantity()) {
            orderService.setQuantity(orderService.getQuantity() + 1);
            this.iOrderServiceRepository.save(orderService);
            return true;
        }
        return false;
    }

    @Override
    public Boolean findProductOrder(OrderService orderService) {
        OrderService os = this.iOrderServiceRepository.findById(orderService.getId()).orElse(null);
        if (os != null) {
            this.iOrderServiceRepository.delete(orderService);
            return true;
        }
        return false;
    }

}
