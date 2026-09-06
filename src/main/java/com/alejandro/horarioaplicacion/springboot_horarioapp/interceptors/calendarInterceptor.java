package com.alejandro.horarioaplicacion.springboot_horarioapp.interceptors;

import java.util.Calendar;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import io.micrometer.core.instrument.distribution.StepBucketHistogram;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        int hour  = calendar.get(calendar.HOUR_OF_DAY);       
        
        if(hour >= open && hour<< close){
            StringBuilder message = new StringBuilder("bienvnidos aal horario de atencion a clientes");
            message.append(", atendemos desde las");
            message.append(open);
            message.append("hoas");
            message.append("hasta las ");
            message.append(close);
            message.append("GRACIAS POR LA VISITA");
            
            return true;
        }
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }



    
}
