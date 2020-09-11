package com.cenfotec.logic;

import java.util.Random;
import java.util.regex.Pattern;

public class Password {
    private Random random = new Random(System.nanoTime());
    private int longitud;
    private String password;

    public Password() {
        this.longitud = 8;
    }

    public Password(int longitud) {
        this.setLongitud(longitud);
    }

    private char addLowerCase(){
        int numberRandom = random.nextInt(ConfigurationPassword.lowerCase.length());
        return ConfigurationPassword.lowerCase.charAt(numberRandom);
    }

    private char addUpperCase(){
        int numberRandom = random.nextInt(ConfigurationPassword.upperCase.length());
        return ConfigurationPassword.upperCase.charAt(numberRandom);
    }

    private char addNumberCase(){
        int numberRandom = random.nextInt(ConfigurationPassword.number.length());
        return ConfigurationPassword.number.charAt(numberRandom);
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud > 8 ? longitud : 8;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean esFuerte(){
        String password = this.getPassword();

        if(!password.matches("^((.*?[a-z]){1,}.*)$")){
            return false;
        }

        if(!password.matches("^((.*?[A-Z]){2,}.*)$")){
            return false;
        }

        if(!password.matches("^(\\D*(?:\\d\\D*){5,})$")){
            return false;
        }

        return true;
    }

    public void generarPassword(){
        StringBuilder passwordCreate = new StringBuilder(this.getLongitud());

        for (int i = 0; i < this.getLongitud(); i++){
            int randomChar = random.nextInt(3);

            if(randomChar == 0){
                passwordCreate.append(addLowerCase());
                continue;
            }

            if(randomChar == 1){
                passwordCreate.append(addUpperCase());
                continue;
            }

            if(randomChar == 2){
                passwordCreate.append(addNumberCase());
                continue;
            }
        }

        setPassword(new String(passwordCreate));
    }
}
