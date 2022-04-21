import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // variables
  PImage imgSetting;
  PImage imgAngryMan;
  float fltAngryManX = 0;
	float fltAngryManY = 0;
  // The reason this movement is not considered linear movement is because there is an exponent which means it's non linear movement. It is quadratic, y=x^2
	double fltAngryManSpeedX = 10;
  double fltAngryManSpeedY = Math.pow(fltAngryManSpeedX,2);
  
  float fltCircleX = 0;
	float fltCircleY = 0;
  double fltCircleSpeedX = 5;
  double fltCircleSpeedY = Math.pow(fltCircleSpeedX,2);

  // set size
  public void settings() {
    size(700, 700);
  }


  public void setup() {
    //background colour
    background(0);

    //load and resize images
    imgSetting = loadImage("Setting.jpg");
    imgSetting.resize(width, height);

    imgAngryMan = loadImage("AngryMan.jpg");
    imgAngryMan.resize(200, 200);
  }


  public void draw() {

    // set image locations
    image(imgSetting, 0, 0);
    image(imgAngryMan, fltAngryManX, fltAngryManY);
    ellipse(fltCircleX, fltCircleY, 50, 50);

    // add speed
    fltCircleX += fltCircleSpeedX;
    fltCircleY += fltCircleSpeedY;
    
    // add collision detection
    if (fltCircleX < 0  || fltCircleX > width - 200) {
      fltCircleSpeedX *= -1;
    }
    if (fltCircleY < 0 || fltCircleY > height - 300) {
      fltCircleSpeedY *= -1;
    }

    // add speed
    fltAngryManX += fltAngryManSpeedX;
    fltAngryManY += fltAngryManSpeedY;

    // add collision detection
    if (fltAngryManX < 0  || fltAngryManX > width - 200) {
      fltAngryManSpeedX *= -1;
    }
    if (fltAngryManY < 0 || fltAngryManY > height - 300) {
      fltAngryManSpeedY *= -1;
    }
  }
}