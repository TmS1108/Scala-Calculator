package ch.makery.calculator.view

import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.scene.text.Text
import scalafx.scene.control.TextField
import scalafx.scene.image.{Image, ImageView}
import scala.math._
import scala.collection.mutable.ListBuffer


@sfxml
class PythagoreanController(
     private val backgroundPythagorean: ImageView,
     private val imageFormula: ImageView,
     private val imageTriangle: ImageView,
     private val textFieldA: TextField,
     private val textFieldB: TextField,
     private val textFieldC: TextField,
     private var value1: String,
     private var value2: String,
     private var convertValue1: Double,
     private var convertValue2: Double,
     private var calculation: Double,
     private var result: String,
     private var text1: Text
     ){
  var list = ListBuffer[String]()
  var count = 0
  backgroundPythagorean.image = new Image("file:resources/images/white2.png")    
  imageFormula.image = new Image("file:resources/images/hypotenuseformula.png")
  imageTriangle.image = new Image("file:resources/images/hypotenuse.png")
 
 def handleBack (action: ActionEvent): Unit = {
        MainApp.showGame()
    }

 def clearTextField(){
    textFieldA.setText("")
    textFieldB.setText("")
    textFieldC.setText("")
 }

//  def clearText(action: ActionEvent){
//      for(x <- 0 until list.length){ 
//         list.remove(x)
//     }
//  }

 def calculate(action: ActionEvent){
    try{
        if (textFieldA.getText() != "" && textFieldB.getText() != "" && textFieldC.getText() == "" || textFieldC.getText() == "0"  ){
            value1 = textFieldA.getText()
            value2 = textFieldB.getText()
            convertValue1 = value1.toDouble
            convertValue2 = value2.toDouble
            calculation = sqrt((convertValue1*convertValue1) + (convertValue2*convertValue2))
            result = calculation.toString
            textFieldC.setText("")
            textFieldC.appendText(result)
        }
        else if (textFieldA.getText() == "" && textFieldB.getText() != "" && textFieldC.getText() != "" || textFieldA.getText() == "0"  ){
            value1 = textFieldB.getText()
            value2 = textFieldC.getText()
            convertValue1 = value1.toDouble
            convertValue2 = value2.toDouble
            if(convertValue2 > convertValue1){
                calculation = sqrt((convertValue2*convertValue2)-(convertValue1*convertValue1))
                result = calculation.toString
                textFieldA.setText("")
                textFieldA.appendText(result)

            }
            else if ((convertValue2 < convertValue1) || (convertValue2 == convertValue1)){
                textFieldA.setText("")
                textFieldA.appendText("C > B ")
            }
        }
        else if (textFieldA.getText() != "" && textFieldB.getText() == "" && textFieldC.getText() != "" || textFieldB.getText() == "0"  ){
            value1 = textFieldA.getText()
            value2 = textFieldC.getText()
            convertValue1 = value1.toDouble
            convertValue2 = value2.toDouble
            if(convertValue2 > convertValue1){
                calculation = sqrt((convertValue2*convertValue2)-(convertValue1*convertValue1))
                result = calculation.toString
                textFieldB.setText("")
                textFieldB.appendText(result)
            }
            else if ((convertValue2 < convertValue1) || (convertValue2 == convertValue1)){
                textFieldB.setText("")
                textFieldB.appendText("C > A ")
            }
        }
        else if (textFieldA.getText() != "" && textFieldB.getText() != "" && textFieldC.getText() != ""){
                clearTextField
        }  

       }catch{
              case x: NumberFormatException =>
              textFieldA.setText("")
              textFieldB.setText("")
              textFieldC.setText("")
              textFieldA.appendText("Error")
              textFieldB.appendText("Error")
              textFieldC.appendText("Error")
             }
            list += "√(" + " (" + value1 + "² + " + value2 + "²) ) =  " + result + "\n"
            text1.text = ""

            for(x <- 0 until list.length){ //0 until 3
                text1.text = text1.text() + list(x)
                count = count + 1
                if (x == 2){
                    list.remove(0)
                    text1.text = text1.text() + list(x)
                    count = 0
                }
                
            }
        }

    }
     