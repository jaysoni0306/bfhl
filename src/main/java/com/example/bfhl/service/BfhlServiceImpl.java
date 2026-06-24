package com.example.bfhl.service;

import com.example.bfhl.dto.RequestDTO;
import com.example.bfhl.dto.ResponseDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public ResponseDTO processData(RequestDTO request) {
        ResponseDTO response = new ResponseDTO();
        response.setIs_success(true);
        response.setUser_id("jay_soni_20042006"); 
        response.setEmail("your_actual_email@college.edu"); // Replace with your email
        response.setRoll_number("YOUR_ROLL_NUMBER"); // Replace with your roll number

        List<String> data = request.getData() != null ? request.getData() : new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialChars = new ArrayList<>();
        long sum = 0;
        StringBuilder alphaChars = new StringBuilder();

        for (String item : data) {
            if (item.matches("-?\\d+")) { 
                long num = Long.parseLong(item);
                sum += num;
                if (num % 2 == 0) evenNumbers.add(item);
                else oddNumbers.add(item);
            } else if (item.matches("^[a-zA-Z]+$")) { 
                alphabets.add(item.toUpperCase());
                alphaChars.append(item);
            } else if (item.matches("^[^a-zA-Z0-9]+$")) { 
                specialChars.add(item);
            }
        }

        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialChars);
        response.setSum(String.valueOf(sum));

        String reversed = alphaChars.reverse().toString();
        StringBuilder concatString = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (i % 2 == 0) concatString.append(Character.toUpperCase(c));
            else concatString.append(Character.toLowerCase(c));
        }
        response.setConcat_string(concatString.toString());

        return response;
    }
}