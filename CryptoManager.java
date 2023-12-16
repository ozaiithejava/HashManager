import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.EnumMap;

public class CryptoManager {

    public enum HashAlgorithm {
        MD5, SHA256, SHA512, SHA3_256, SHA3_512, SHAKE128, SHAKE256, WHIRLPOOL
    }

    private static final EnumMap<HashAlgorithm, String> algorithmNames = new EnumMap<>(HashAlgorithm.class);

    static {
        algorithmNames.put(HashAlgorithm.MD5, "MD5");
        algorithmNames.put(HashAlgorithm.SHA256, "SHA-256");
        algorithmNames.put(HashAlgorithm.SHA512, "SHA-512");
        algorithmNames.put(HashAlgorithm.SHA3_256, "SHA3-256");
        algorithmNames.put(HashAlgorithm.SHA3_512, "SHA3-512");
        algorithmNames.put(HashAlgorithm.SHAKE128, "SHAKE128");
        algorithmNames.put(HashAlgorithm.SHAKE256, "SHAKE256");
        algorithmNames.put(HashAlgorithm.WHIRLPOOL, "Whirlpool");
    }

    public static String hashing(String password, HashAlgorithm algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithmNames.get(algorithm));
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert to hexadecimal representation
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null; // Handle the error appropriately in your application
        }
    }
}
