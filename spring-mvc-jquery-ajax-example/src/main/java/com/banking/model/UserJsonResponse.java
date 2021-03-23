package com.banking.model;


import java.util.Map;

public class UserJsonResponse {
   private User user;
   private boolean validated;
   private Map<String, String> errorMessages;

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public Map<String, String> getErrorMessages() {
      return errorMessages;
   }

   public void setErrorMessages(Map<String, String> errorMessages) {
      this.errorMessages = errorMessages;
   }

   public boolean isValidated() {
      return validated;
   }

   public void setValidated(boolean validated) {
      this.validated = validated;
   }
}
