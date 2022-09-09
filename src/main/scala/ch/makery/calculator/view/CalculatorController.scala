package ch.makery.calculator.view

//import scala.collection.mutable.ListBuffer
import scalafx.scene.text.Text
import scalafx.scene.control.TextField
import scalafxml.core.macros.sfxml
import ch.makery.calculator.MainApp
import scala.math._
import scalafx.scene.image.{Image, ImageView}
import scalafx.event.ActionEvent


@sfxml
class CalculatorController(
  private val backgroundCalculator: ImageView,
  private val textField: TextField,
  private var save1: String,
  private var save2: String,
  private var save3: String,
  private var save4: String,
  private var factorial1: Int,
  private var operation: Int,
  private var calculation: Double,
  private var calculationInt: Int,
  private var convertSave1: Double,
  private var convertSave2: Double,
  private var convertInt: Int,
  private var result: String,
  private var word: String
  ) {
   backgroundCalculator.image = new Image("file:resources/images/calculatorbackground.jpg")

    def button1(action: ActionEvent): Unit = {
        textField.appendText("1")
    }

    def button2(action: ActionEvent): Unit = {
        textField.appendText("2")
    }

    def button3(action: ActionEvent): Unit = {
        textField.appendText("3")
    }

    def button4(action: ActionEvent): Unit = {
        textField.appendText("4")
    }

    def button5(action: ActionEvent): Unit = {
        textField.appendText("5")
    }

    def button6(action: ActionEvent): Unit = {
        textField.appendText("6")
    }

    def button7(action: ActionEvent): Unit = {
        textField.appendText("7")
    }

    def button8(action: ActionEvent): Unit = {
        textField.appendText("8")
    }

    def button9(action: ActionEvent): Unit = {
        textField.appendText("9")
    }


    def button0(action: ActionEvent): Unit = {
        textField.appendText("0")
    }


    def buttonDot(action: ActionEvent): Unit = {
        textField.appendText(".")
    }


    def buttonDelete(action: ActionEvent): Unit = {
      if (textField.getText != ""){
        textField.setText(""+textField.getText().substring(0, textField.getText ().length - 1))
      }
    }
  
    def clearTextField(action: ActionEvent){
        textField.setText("")
    }

    def pythagorean(action: ActionEvent){
      MainApp.showPythagoreanPage()
    }

    def angle(action: ActionEvent){
      MainApp.showAnglePage()
    }

    def mass(action: ActionEvent){
      MainApp.showMassPage()
    }

    def handleBack (action: ActionEvent): Unit = {
      MainApp.showFrontPage()
    }

    def buttonEqual(action: ActionEvent): Unit = {
        word = textField.getText()  
        if ( operation == 1 ){
          try{
            save2 = word.slice(word.indexOf("+")+1,word.length())
            convertSave1 = ParseDouble(save1)
            convertSave2 = ParseDouble(save2)
            textField.setText("")
            calculation = convertSave1 + convertSave2
            result = calculation.toString
            textField.appendText(result)
          }catch {
            case x: NumberFormatException =>
                textField.setText("")
                textField.appendText("Syntax Error")

            }
          }
        
        else if ( operation == 2 ){
           try{
            save2 = word.slice(word.indexOf("-")+1,word.length())
            convertSave1 = ParseDouble(save1)
            convertSave2 = ParseDouble(save2)
            textField.setText("")
            calculation = convertSave1 - convertSave2
            result = calculation.toString
            textField.appendText(result)
           
          }catch {
            case x: NumberFormatException =>
                textField.setText("")
                textField.appendText("Syntax Error")

            }
          }
        

         else if ( operation == 3 ){
          try{
            save2 = word.slice(word.indexOf("×")+1,word.length())
            convertSave1 = ParseDouble(save1)
            convertSave2 = ParseDouble(save2)
            textField.setText("")
            calculation = convertSave1 * convertSave2
            result = calculation.toString
            textField.appendText(result)
            }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }

        }

         else if ( operation == 4){
          try{
           save2 = word.slice(word.indexOf("÷")+1,word.length())
           convertSave2 = ParseDouble(save2)
           convertSave1 = ParseDouble(save1)
            textField.setText("")
            calculation = convertSave1 / convertSave2
            result = calculation.toString
            textField.appendText(result)
          }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
         }

         else if ( operation == 5 ){ 
         try{
              save2 = word.slice(word.indexOf("√")+1,word.length)
              convertSave2 = ParseDouble(save2)
              if (save1 != ""){
                  convertSave1 = ParseDouble(save1)
                  textField.setText("")
                  calculation = convertSave1*(math.sqrt(convertSave2))
                  result = calculation.toString
                  textField.appendText(result)
                  }
                  else{
                  textField.setText("")
                  calculation = (math.sqrt(convertSave2))
                  result = calculation.toString
                  textField.appendText(result)
                  }
            }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
         }

         else if ( operation == 6 ){
          try{
            save2 = word.slice(word.indexOf("√")+1,word.length)
            convertSave2 = ParseDouble(save2)
           if (save1 != ""){
              convertSave1 = ParseDouble(save1)
              textField.setText("")
              calculation = convertSave1*(math.cbrt(convertSave2))
              result = calculation.toString
              textField.appendText(result)
           }

           else{
              textField.setText("")
              calculation = math.cbrt(convertSave2)
              result = calculation.toString
              textField.appendText(result)
           }
            }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
         }

          else if ( operation == 7 ){
          try{
                if (textField.getText() != ""){
                  save2 = word.slice(word.indexOf("^")+1,word.length)
                  convertSave1 = ParseDouble(save1)
                  convertSave2 = ParseDouble(save2)
                  textField.setText("")
                  calculation = math.pow(convertSave1,convertSave2)
                  result = calculation.toString
                  textField.appendText(result)
                  }
              }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
         }

          else if ( operation == 8 ){
            try{
                save2 = word.slice(word.indexOf("n")+1,word.length)
                convertSave2 = ParseDouble(save2)
                if (save1 != ""){
                  convertSave1 = ParseDouble(save1)
                  textField.setText("")
                  calculation = convertSave1*(math.sin(convertSave2))
                  result = calculation.toString
                  textField.appendText(result)
                }
                else{
                  textField.setText("")
                  calculation = (math.sin(convertSave2))
                  result = calculation.toString
                  textField.appendText(result)
                }
            }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
         }

         else if ( operation == 9 ){
          try{
           save2 = word.slice(word.indexOf("s")+1,word.length)
           convertSave2 = ParseDouble(save2)

          if (save1 != ""){
            convertSave1 = ParseDouble(save1)
            textField.setText("")
            calculation = convertSave1*(math.cos(convertSave2))
            result = calculation.toString
            textField.appendText(result)
          }
          else{
            textField.setText("")
            calculation = (math.cos(convertSave2))
            result = calculation.toString
            textField.appendText(result)
          }
            }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
         }

         else if ( operation == 10 ){ 
          try{
            save2 = word.slice(word.indexOf("n")+1,word.length)
             convertSave2 = ParseDouble(save2)
            if (save1 != ""){
              convertSave1 = ParseDouble(save1)
              textField.setText("")
              calculation = convertSave1*(math.tan(convertSave2))
              result = calculation.toString
              textField.appendText(result)
            }
            else{
              textField.setText("")
              calculation = (math.tan(convertSave2))
              result = calculation.toString
              textField.appendText(result)
            }
             }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
         }
          else if ( operation == 11 ){
            try{
              save2 = word.slice(word.indexOf("g")+1,word.length)
              convertSave2 = ParseDouble(save2)
  
              if (save1 != ""){
              convertSave1 = ParseDouble(save1)
              textField.setText("")
              calculation = convertSave1*(math.log(convertSave2))
              result = calculation.toString
              textField.appendText(result)
            }
            else{
              textField.setText("")
              calculation = (math.log(convertSave2))
              result = calculation.toString
              textField.appendText(result)
            }
            }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
          }
        
           else if ( operation == 12 ){
            try{
            convertSave1 = ParseDouble(save1)
            textField.setText("")
            calculation = math.pow(convertSave1,2)
            result = calculation.toString
            textField.appendText(result)
            }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
          } 


          else if ( operation == 13 ){
          try{
            convertSave1 = ParseDouble(save1)
            textField.setText("")
            calculation = math.pow(convertSave1,3)
            result = calculation.toString
            textField.appendText(result)
            }catch{
                case x: NumberFormatException =>
                  textField.setText("")
                  textField.appendText("Syntax Error")

            }
          } 
          else if ( operation == 14 ){
                  try{
                      convertSave1 = ParseDouble(save1)
                      calculation = convertSave1/100
                      result = calculation.toString
                      textField.setText("")
                      textField.appendText(result)
                    }catch{
                        case x: NumberFormatException =>
                          textField.setText("")
                          textField.appendText("Syntax Error")

                    }
                  } 

          else if ( operation == 15 ){
            try{
                 convertInt = save1.toInt
                  if (convertInt >= 0 && convertInt <= 33){
                        var factorial1 = 1
                        for(i <- 1 to convertInt)
                            {
                              factorial1 = factorial1 * i;
                            }
                              calculation = factorial1
                              result = calculation.toString
                              textField.setText("")
                              textField.appendText(result)
                        }
                        else if (convertInt > 33){
                              textField.setText("")
                              textField.setText("LIMIT")
                        }
            }catch{
                      case x: NumberFormatException =>
                      textField.setText("")
                      textField.appendText("Error")

                    }
                }
          else if ( operation == 16 ){
            try{
                  textField.appendText("π")
                  convertSave1 = ParseDouble(save1)
                  calculation = convertSave1*3.142
                  result = calculation.toString
                  textField.setText("")
                  textField.appendText(result)     
          }catch{
                      case x: NumberFormatException =>
                      textField.setText("")
                      textField.appendText("Error")

                    }
        }
    }
          
          
    
    
    def ParseDouble(converter: String): Double = {
         if (textField.getText() != "" || !(textField.getText().isEmpty())){
             return converter.toDouble 

            }
            else{
               return 0.0
            }
    }

    def addition(action: ActionEvent): Unit = {
      save1 = textField.getText()
      textField.appendText("+")
      operation = 1
    }

     def subtraction(action: ActionEvent): Unit = {
      save1 = textField.getText()
      textField.appendText("-")
      operation = 2

    }

     def multiplication(action: ActionEvent): Unit = {
      save1 = textField.getText()
      textField.appendText("×")
      operation = 3

    }

     def division(action: ActionEvent): Unit = {
      save1 = textField.getText()
      textField.appendText("÷")
      operation = 4
    }

    def squareRoot(action: ActionEvent): Unit = {
      save1 = textField.getText()
      textField.appendText("√")
      operation = 5
      }
    
    def cubeRoot(action: ActionEvent): Unit = {
       save1 = textField.getText()
       textField.appendText("3√")
       operation = 6
    }

    def power(action: ActionEvent): Unit = {
      save1 = textField.getText()
      textField.appendText("^")
      operation = 7

    }

    def sin(action: ActionEvent): Unit = {
       save1 = textField.getText()
       textField.appendText("sin")
       operation = 8
    }

    def cos(action: ActionEvent): Unit = {
       save1 = textField.getText()
       textField.appendText("cos")
       operation = 9
    }

    def tan(action: ActionEvent): Unit = {
       save1 = textField.getText()
       textField.appendText("tan")
       operation = 10
    }

    def log(action: ActionEvent): Unit = {
       save1 = textField.getText()
       textField.appendText("log")
       operation = 11
    }


    def powerOfTwo(action: ActionEvent): Unit = {
      save1 = textField.getText()
      textField.appendText("²")
      operation = 12

    }

    def powerOfThree(action: ActionEvent): Unit = {
      save1 = textField.getText()
      textField.appendText("³")
      operation = 13

    }

    def percentage(action: ActionEvent): Unit = {
        save1 = textField.getText()
        textField.appendText("%")
        operation = 14
      }

    def factorial(action: ActionEvent): Unit = {
      save1 = textField.getText()
      textField.appendText("!")
      operation = 15
    }

    def pi(action: ActionEvent): Unit = {
    operation = 16

    if (textField.getText != ""){
       save1 = textField.getText()
       textField.appendText("π")
    }
    else{
        textField.appendText("3.142")
        }
  
  }
}

  


     //  for (i <- 0 until word.length()){
          //   if ((word.charAt(i) == '+')||(word.charAt(i) == '-')||(word.charAt(i) == 'x')||(word.charAt(i) == '÷')) {
          //   listOfIndex += i
          //   }
          // }

          // for (i <- 0 until listOfIndex.length ) 
          // {
          //   if (i < listOfIndex.length-1){ //b4 the last index to avoid the index out of boundary
          //     listOfSave += word.slice(listOfIndex(i)+1,listOfIndex(i+1)) 
          //   }
          //   else if (i == listOfIndex.length-1){
          //     listOfSave += word.slice(listOfIndex(i)+1,word.length) 

          //   }
          // }
