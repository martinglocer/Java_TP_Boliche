package servlet;
import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SvCreatePaymentIntent", urlPatterns = "/SvCreatePaymentIntent")
public class SvCreatePaymentIntent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(SvCreatePaymentIntent.class.getName());
    
    @Override
    public void init() throws ServletException {
        Stripe.apiKey = "sk_test_51QNLtpAgf9Xw1p1yN3CM1nN1RfMZnL6WFXjVIkFgXj4w0ldIO8HJwYm0bBtZmMU2tPK7G1T4M8PtPJvvK9h0pMPv003uGAr10Q";
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Leer el JSON del body
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            
            // Convertir el JSON a un Map
            Map<String, Object> jsonData = new Gson().fromJson(buffer.toString(), Map.class);
            double amount = ((Number) jsonData.get("amount")).doubleValue();
            
            // Crea los parámetros del Payment Intent
            PaymentIntentCreateParams params =
                    PaymentIntentCreateParams.builder()
                            .setAmount((long)amount) // Monto en centavos
                            .setCurrency("usd")
                            .setAutomaticPaymentMethods(
                                    PaymentIntentCreateParams.AutomaticPaymentMethods
                                            .builder()
                                            .setEnabled(true)
                                            .build()
                            )
                            .build();
            
            // Crea el Payment Intent
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            logger.log(Level.INFO, "Payment Intent creado: {0}", paymentIntent.getId());
            
            // Crea un mapa con el clientSecret del Payment Intent
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("clientSecret", paymentIntent.getClientSecret());
            
            // Envía la respuesta como JSON
            response.setContentType("application/json");
            response.getWriter().println(new Gson().toJson(responseData));
            
        } catch (StripeException e) {
            logger.log(Level.SEVERE, "Error al crear el Payment Intent", e);
            response.setStatus(500);
            response.getWriter().println("Error al crear el Payment Intent: " + e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al procesar la solicitud", e);
            response.setStatus(400);
            response.getWriter().println("Error al procesar la solicitud: " + e.getMessage());
        }
    }
}