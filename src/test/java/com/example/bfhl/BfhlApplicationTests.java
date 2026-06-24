package com.example.bfhl;

import com.example.bfhl.dto.RequestDTO;
import com.example.bfhl.dto.ResponseDTO;
import com.example.bfhl.service.BfhlService;
import com.example.bfhl.service.BfhlServiceImpl;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BfhlApplicationTests {

    @Test
    void testProcessDataExampleC() { 
        BfhlService service = new BfhlServiceImpl();
        RequestDTO request = new RequestDTO();
        request.setData(Arrays.asList("A", "ABCD", "DOE")); 
        
        ResponseDTO response = service.processData(request);
        
        assertEquals("EoDdCbAa", response.getConcat_string()); 
        assertEquals("0", response.getSum()); 
        assertEquals(Arrays.asList("A", "ABCD", "DOE"), response.getAlphabets()); 
    }
}