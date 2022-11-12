package com.flash.config;

import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.helper.ConditionalHelpers;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import pl.allegro.tech.boot.autoconfigure.handlebars.HandlebarsHelper;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Configuration
public class HandlebarsConfiguration {

    @Autowired
    private HandlebarsViewResolver handlebarsViewResolver;

    @PostConstruct
    void postConstruct() {
        handlebarsViewResolver.getHandlebars().registerHelper("gt", ConditionalHelpers.gt);
    }

    @HandlebarsHelper
    public static class IfEqualHelper {
        public CharSequence ifEqual(final Object obj1, final Options options) throws IOException {
            Object obj2 = options.param(0);
            if (obj1 instanceof Enum) {
                Enum obj1AsEnum = (Enum)obj1;
                return Objects.equal(obj1AsEnum.name(), obj2) ? options.fn() : options.inverse();
            }
            if (obj2 instanceof Enum) {
                Enum obj2AsEnum = (Enum)obj2;
                return Objects.equal(obj1, obj2AsEnum.name()) ? options.fn() : options.inverse();
            }
            return Objects.equal(obj1, obj2) ? options.fn() : options.inverse();
        }
    }

    @HandlebarsHelper
    public static class ContainsHelper {
        public CharSequence contains(Object list, Options options) throws IOException {
            Object obj = options.param(0);
            if(list instanceof Collection) {
                for(Object param : options.params) {
                    for (Object firstParam : ((Collection<?>) list)) {
                        if(param.equals(firstParam)) {
                            return options.fn();
                        }
                    }
                }
                return options.inverse();
            } else {
                return options.inverse();
            }
        }
    }

//    @HandlebarsHelper
//    public static class FindFieldError {
//        public CharSequence findFieldError(List<ServiceValidationException.FieldErrorDto> errors, Options options) {
//            String key = options.param(0);
//
//            if (errors == null || key == null) {
//                return "";
//            }
//
//            return errors
//                    .stream()
//                    .filter(err -> err.getField().equals(key))
//                    .map(ServiceValidationException.FieldErrorDto::getError)
//                    .collect(Collectors.joining(". "));
//        }
//    }

//    @HandlebarsHelper
//    public static class HasFieldError {
//        public CharSequence hasFieldError(List<ServiceValidationException.FieldErrorDto> errors, Options options)
//                throws IOException {
//            String key = options.param(0);
//
//            if (errors == null || key == null) {
//                return "";
//            }
//
//            if (errors.stream().anyMatch(err -> err.getField().equals(key))) {
//                return options.fn();
//            } else {
//                return options.inverse();
//            }
//        }
//    }
}

