import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener {
    private static final String BASE_URL = "http://short.ly/";
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;
    
    private Map<String, String> urlMap;
    private Random random;

    public LinkShortener() {
        urlMap = new HashMap<>();
        random = new Random();
    }

    public String shortenUrl(String originalUrl) {
        String shortUrl = generateShortUrl();
        urlMap.put(shortUrl, originalUrl);
        return BASE_URL + shortUrl;
    }

    public String getOriginalUrl(String shortUrl) {
        String key = shortUrl.replace(BASE_URL, "");
        return urlMap.get(key);
    }

    private String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder(SHORT_URL_LENGTH);
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortUrl.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return shortUrl.toString();
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        
        String originalUrl = "https://www.example.com/some/very/long/url";
        String shortUrl = linkShortener.shortenUrl(originalUrl);
        System.out.println("Short URL: " + shortUrl);
        
        String retrievedUrl = linkShortener.getOriginalUrl(shortUrl);
        System.out.println("Original URL: " + retrievedUrl);
    }
}