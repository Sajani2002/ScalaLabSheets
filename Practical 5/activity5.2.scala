case class Book(title: String, author: String, isbn: String)

object LibraryManagement {
  var library: Set[Book] = Set(
    Book("1984", "George Orwell", "1005"),
    Book("To Kill a Mockingbird", "Harper Lee", "2003"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "1234")
  )

  def addBook(book: Book): Unit = {
    library += book
  }

  def removeBookByIsbn(isbn: String): Unit = {
    library = library.filterNot(_.isbn == isbn)
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  def searchBookByTitle(title: String): Option[Book] = {
    library.find(_.title.equalsIgnoreCase(title))
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.isEmpty) {
      println(s"No books found by author: $author")
    } else {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    }
  }

  def main(args: Array[String]): Unit = {
    displayLibrary()

    addBook(Book("abcde", "sajani", "124"))
    println("\nAfter adding a new book:")
    displayLibrary()

    removeBookByIsbn("124")
    println("\nAfter removing a book by ISBN:")
    displayLibrary()

    println(s"\nIs '1984' in the library? ${isBookInLibrary("1005")}")

    searchBookByTitle("1984") match {
      case Some(book) => println(s"\nFound book: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None => println("\nBook not found")
    }

    displayBooksByAuthor("Harper Lee")
  }
}
