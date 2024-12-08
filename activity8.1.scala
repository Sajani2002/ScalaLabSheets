object CaesarCipher {
  val alphabet = ('A' to 'Z').mkString 

  // Encryption function
  def encrypt(text: String, shift: Int): String = {
    text.toUpperCase.map { char =>
      if (alphabet.contains(char)) {
        val shiftedIndex = (alphabet.indexOf(char) + shift) % alphabet.length
        alphabet(shiftedIndex)
      } else {
        char // Non-alphabetic characters are not encrypted
      }
    }
  }

  // Decryption function
  def decrypt(text: String, shift: Int): String = {
    text.toUpperCase.map { char =>
      if (alphabet.contains(char)) {
        val shiftedIndex = (alphabet.indexOf(char) - shift + alphabet.length) % alphabet.length
        alphabet(shiftedIndex)
      } else {
        char // Non-alphabetic characters are not decrypted
      }
    }
  }
}

object CipherProcessor {
  def process(text: String, shift: Int, cipherFunction: (String, Int) => String): String = {
    cipherFunction(text, shift)
  }
}

object CaesarCipherApp extends App {
  val plaintext = "cat"
  val shift = 5

  println(s"Plain text: $plaintext")
  // Encrypt the plaintext
  val encryptedText = CipherProcessor.process(plaintext, shift, CaesarCipher.encrypt)
  println(s"Encrypted Text: $encryptedText")

  // Decrypt the ciphertext
  val decryptedText = CipherProcessor.process(encryptedText, shift, CaesarCipher.decrypt)
  println(s"Decrypted Text: $decryptedText")
}
