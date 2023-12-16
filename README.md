# HashManager
basic manager usefuly

## Usage:
```Java
public class Main {

    public static void main(String[] args) {
        String password = "yourPassword";
        CryptoManager.HashAlgorithm algorithm = CryptoManager.HashAlgorithm.SHA256;

        String hashedPassword = CryptoManager.hashing(password, algorithm);
        System.out.println("Hashed Password (" + algorithm + "): " + hashedPassword);
    }
}
```
