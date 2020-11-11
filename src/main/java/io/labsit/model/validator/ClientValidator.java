package io.labsit.model.validator;

import io.labsit.model.Client;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ClientValidator implements ConstraintValidator<ValidClient, Client> {

    @Override
    public boolean isValid(Client client, ConstraintValidatorContext context) {
        return validateControllerChannel(client, context);
    }

    private boolean validateControllerChannel(Client client, ConstraintValidatorContext context) {
        if (nonNull(client.getCnpj()) && nonNull(client.getCpf())) {
            context.buildConstraintViolationWithTemplate("Deve ser informado somente o CPF ou CNPJ").addConstraintViolation();
            return false;
        } else if (isNull(client.getCnpj()) && isNull(client.getCpf())) {
            context.buildConstraintViolationWithTemplate("O CPF ou o CNPJ é obrigatório").addConstraintViolation();
            return false;
        }
        return true;
    }

}