package com.example._63070047week4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


@Route(value = "index")
public class MathView extends FormLayout {
    public MathView() {
        TextField n1 = new TextField();
        n1.setLabel("Number1");

        TextField n2 = new TextField();
        n2.setLabel("Number2");

        Button btn1 = new Button("+");
        Button btn2 = new Button("-");
        Button btn3 = new Button("*");
        Button btn4 = new Button("/");
        Button btn5 = new Button("Mod");
        Button btn6 = new Button("Max");

        TextField result = new TextField();
        result.setLabel("Answer");

        HorizontalLayout hl = new HorizontalLayout();
        VerticalLayout vl = new VerticalLayout();

        hl.add(btn1, btn2, btn3, btn4, btn5, btn6);
        vl.add(n1, n2, hl, result);
        this.add(vl);

        btn1.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            result.setValue(out);
        });

        btn2.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            result.setValue(out);
        });

        btn3.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            result.setValue(out);
        });

        btn4.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            result.setValue(out);
        });

        btn5.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            result.setValue(out);
        });
        btn6.addClickListener(event ->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("n1", n1.getValue());
            formData.add("n2", n2.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            result.setValue(out);
        });
    }
}
