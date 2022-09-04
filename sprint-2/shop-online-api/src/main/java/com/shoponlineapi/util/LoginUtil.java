package com.shoponlineapi.util;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Data
public class LoginUtil {
    private Map<String, String> tokenMap = new HashMap<>();
}
