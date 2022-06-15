package project.service.impl;

import org.springframework.stereotype.Service;
import project.service.ICurrencyService;

@Service
public class CurrencyService implements ICurrencyService {
    @Override
    public int exchange(int usd, int rate) {
        return usd * rate;
    }
}
