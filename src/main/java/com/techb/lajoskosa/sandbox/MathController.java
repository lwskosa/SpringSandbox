package com.techb.lajoskosa.sandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/addition/{numberA}/{numberB}")
    public String addition(@PathVariable int numberA, @PathVariable int numberB){
        String result = String.format("%d + %d = %d",numberA,numberB, numberA+numberB);
        String formatted = String.format("    <div class=\"p-6 m-auto\">\n" +
                "        <h1 class=\"text-center\">Result</h1>\n" +
                "        <h2 class=\"text-center\" id=\"result\">%s</h2>\n" +
                "    </div>",result);
    return  formatted;


    }
}
