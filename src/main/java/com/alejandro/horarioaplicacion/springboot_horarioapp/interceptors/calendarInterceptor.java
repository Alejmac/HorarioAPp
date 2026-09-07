package com.alejandro.horarioaplicacion.springboot_horarioapp.interceptors;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView; 

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component 
public class calendarInterceptor implements HandlerInterceptor{
    
    @Value("${config.calendar.open}")
    private  Integer open ;
    @Value("${config.calendar.close}")
    private  Integer close;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
      
        Calendar calendar = Calendar.getInstance();
        Integer hour  = calendar.get(calendar.HOUR_OF_DAY);       
        
        if(hour >= open && hour <= close){
            StringBuilder message = new StringBuilder("bienvnidos aal horario de atencion a clientes ");
            message.append(", atendemos desde las ");
            message.append(open);
            message.append(" hoas ");
            message.append(" hasta las ");
            message.append(close);
            message.append(" GRACIAS POR LA VISITA ");
            request.setAttribute(" message", message.toString());
            return true;
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> data = new HashMap<>();
        StringBuilder message = new StringBuilder("Cerrado, fuera del horario de atencion");
        message.append("por favor visitenos desde las");
        message.append(open);
        message.append("y las ");
        message.append(close);
        message.append("hrs, Gracias !");
        data.put("message", message.toString());
        data.put("day", new Date(0).toString());
        response.setContentType("aplication/json");
        response.setStatus(404);
        response.getWriter().write(mapper.writeValueAsString(data));
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }



    
}
