public class SendingEmail {

  public static void main(String user) throws AddressException, MessagingException {

    Properties prop = new Properties();
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true");
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

    String email = ""; //Enter email that we will use to send the email
    String password = ""; //Enter password that will connect to this email^^

    Session sess = Session.getInstance(prop, new Authenticator(){

      protected PasswordAuthenticate getPasswordAuthentication(){
        return new PasswordAuthenticate(email, password):
      }
      });

    MimeMessage message = new MimeMessage(sess);
    message.setFrom(new InternetAddress(email));
    message.setText(null); //This will be changed later to fit the users' needs

    Transport.send(message);
}

public void send(JobExecutionContext arg0) throws JobExecution {

  try{ 
      
    SendingEmail.main(email):
  }catch(MessagingException e){

    e.printStackTrace();

}

}

}