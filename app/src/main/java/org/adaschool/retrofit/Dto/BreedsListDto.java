package org.adaschool.retrofit.Dto;

import java.util.Map;

public class BreedsListDto {
    private String status;
    private Map<String, String[]> message;

    private String messages;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String[]> getMessage() {
        return message;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessage(Map<String, String[]> message) {
        this.message = message;
    }
}

