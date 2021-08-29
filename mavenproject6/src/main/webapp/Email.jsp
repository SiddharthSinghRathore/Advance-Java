
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="java.net.PasswordAuthentication"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.net.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.*,javax.mail.*"%>

<%@page import="javax.mail.internet.*" %>
<%
  
    String result;
    
    final String to=request.getParameter("mail");
    final String subject=request.getParameter("sub");
    final String messg=request.getParameter("mess");
    



    final String from="rathoresiddharth786@gmail.com";
    final String pass="19961947";
    
    
    String host="smtp.gmail.host";

    Properties pros=new Properties();
    
    pros.put("mail.smtp.host",host);
    pros.put("mail.transport.protocol","smtp");
    pros.put("mail.smtp.auth","true");
    pros.put("mail.smtp.starttls.enable","true");
    pros.put("mail.user",from);
    pros.put("mail.password",pass);
    pros.put("mail.smto.port","587");
    
    Session mailSession = Session.getInstance(pros, new javax.mail.Authenticator() {

        @Override

        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(from, pass);

        }

    });
    
    try
    {
        MimeMessage message = new MimeMessage(mailSession);
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
        message.setSubject(subject);
        message.setText(messg);
        Transport.send(message);
        
        result="Message sent Succefully";
        
            
    }
    catch(MessagingException mex)
    {
        result="Error Unable to load send the message";
    }
}
    

%>