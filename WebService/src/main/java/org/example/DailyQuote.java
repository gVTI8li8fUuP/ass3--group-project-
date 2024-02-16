import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dailyquote")
public class DailyQuoteService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String[] HAPPY_QUOTES = {
            "Happiness is not something ready made. It comes from your own actions. - Dalai Lama",
            "The only way to do great work is to love what you do. - Steve Jobs",
            "Success is not the key to happiness. Happiness is the key to success. - Albert Schweitzer"
    };

    private static final String[] SAD_QUOTES = {
            "The best way to cheer yourself up is to try to cheer somebody else up. - Mark Twain",
            "Tears come from the heart and not from the brain. - Leonardo da Vinci",
            "Sadness flies away on the wings of time. - Jean de La Fontaine"
    };

    private static final String[] EXAM_QUOTES = {
            "Success is walking from failure to failure with no loss of enthusiasm. - Winston Churchill",
            "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt",
            "Believe you can and you're halfway there. - Theodore Roosevelt"
    };

    private static final String[] JOYFUL_QUOTES = {
            "The most wasted of all days is one without laughter. - E.E. Cummings",
            "The sun himself is weak when he first rises, and gathers strength and courage as the day gets on. - Charles Dickens",
            "Let us be grateful to people who make us happy, they are the charming gardeners who make our souls blossom. - Marcel Proust"
    };

    private static final String[] ANXIOUS_QUOTES = {
            "Worry does not empty tomorrow of its sorrow, it empties today of its strength. - Corrie ten Boom",
            "The only limit to our realization of tomorrow will be our doubts of today. - Franklin D. Roosevelt",
            "It's not stress that kills us, it is our reaction to it. - Hans Selye"
    };

    private static final String[] IRRITABLE_QUOTES = {
            "How much more grievous are the consequences of anger than the causes of it. - Marcus Aurelius",
            "When angry, count to ten before you speak. If very angry, count to one hundred. - Thomas Jefferson",
            "Speak when you are angry and you will make the best speech you will ever regret. - Ambrose Bierce"
    };

    private static final String[] EXCITED_QUOTES = {
            "The only limit to our realization of tomorrow will be our doubts of today. - Franklin D. Roosevelt",
            "Success is not the key to happiness. Happiness is the key to success. - Albert Schweitzer",
            "Believe you can and you're halfway there. - Theodore Roosevelt"
    };

    private static final String[] BORING_QUOTES = {
            "Life is never boring, but some people choose to be bored. - Wayne Dyer",
            "Boredom is the feeling that everything is a waste of time; serenity, that nothing is. - Thomas Szasz",
            "The cure for boredom is curiosity. There is no cure for curiosity. - Dorothy Parker"
    };

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Daily Quote Service</title></head><body>");
        out.println("<h1>Daily Quote of Inspiration</h1>");
        out.println("<p>" + getRandomQuote() + "</p>");
        out.println("</body></html>");
    }

    public static String getDailyQuote(String mood) {
        Random random = new Random();
        switch (mood.toLowerCase()) {
            case "happy":
                return HAPPY_QUOTES[random.nextInt(HAPPY_QUOTES.length)];
            case "sad":
                return SAD_QUOTES[random.nextInt(SAD_QUOTES.length)];
            case "exam":
                return EXAM_QUOTES[random.nextInt(EXAM_QUOTES.length)];
            case "joyful":
                return JOYFUL_QUOTES[random.nextInt(JOYFUL_QUOTES.length)];
            case "anxious":
                return ANXIOUS_QUOTES[random.nextInt(ANXIOUS_QUOTES.length)];
            case "irritable":
                return IRRITABLE_QUOTES[random.nextInt(IRRITABLE_QUOTES.length)];
            case "excited":
                return EXCITED_QUOTES[random.nextInt(EXCITED_QUOTES.length)];
            case "boring":
                return BORING_QUOTES[random.nextInt(BORING_QUOTES.length)];
            default:
                return "Invalid mood or situation provided.";
        }
    }

}
