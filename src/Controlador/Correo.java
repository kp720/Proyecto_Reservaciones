/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author kp728
 */


import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class Correo {

    public static String crearPDF(int id_vuelo) {
        String datos[] = InterfazBase.datosVuelo(id_vuelo);
        String pdfFilePath = "reservacion-confirmacion.pdf";
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Confirmacion de reserva");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Fecha de salida: " + datos[0]);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Hora de salida: " + datos[1]);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Fecha de llegada: " + datos[2]);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Hora de llegada: " + datos[3]);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Lugar de origen: " + datos[4]);
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Lugar de destino: " + datos[5]);
                contentStream.endText();
            }
            document.save(pdfFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pdfFilePath;
    }
    
    public static void enviarPDF(String destinatario, int id_vuelo) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("Correo de envio/empresarial", "contraseña");
            }
        });
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Correo de envio/empresarial"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject("Reserva de vuelo");
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Gracias por su preferencia! Adjunto a este correo se encuentra un documento PDF con las especificaciones de su vuelo.");
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            
            messageBodyPart = new MimeBodyPart();
            String pdfFilePath = crearPDF(id_vuelo);
            DataSource source = new FileDataSource(pdfFilePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("reserva_confirmada.pdf");
            multipart.addBodyPart(messageBodyPart);
            
            message.setContent(multipart);
            
            Transport.send(message);
            System.out.println("Correo enviado con éxito.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }   
    }
}
