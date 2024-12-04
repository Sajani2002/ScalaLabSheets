import scala.io.StdIn.readLine

object StudentRecords extends App {
  // Function to validate user input
  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.trim.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (marks < 0 || totalMarks < 0) {
      (false, Some("Marks and total possible marks must be positive integers."))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks."))
    } else {
      (true, None)
    }
  }

  // Function to get student info
  def getStudentInfo(name: String, marks: Int, totalMarks: Int): (String, Int, Int, Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
    (name, marks, totalMarks, percentage, grade)
  }

  // Function to print student record
  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name        : $name")
    println(s"Marks               : $marks")
    println(s"Total Possible Marks: $totalMarks")
    println(f"Percentage          : $percentage%.2f%%")
    println(s"Grade               : $grade")
  }

  // Function to retry until valid data is provided
  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var studentInfo: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'F')

    while (!isValid) {
      try {
        val name = readLine("Enter student name: ")
        val marks = readLine("Enter student marks: ").toInt
        val totalMarks = readLine("Enter total possible marks: ").toInt

        val validationResult = validateInput(name, marks, totalMarks)
        isValid = validationResult._1

        if (!isValid) {
          println(s"Error: ${validationResult._2.get}")
        } else {
          studentInfo = getStudentInfo(name, marks, totalMarks)
        }
      } catch {
        case e: NumberFormatException => println("Marks and total possible marks must be integers.")
      }
    }

    studentInfo
  }

  // Main logic
  val studentRecord = getStudentInfoWithRetry()
  printStudentRecord(studentRecord)
}
