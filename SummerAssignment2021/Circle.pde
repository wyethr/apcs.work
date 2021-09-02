class Circle {
  
  float x, y, size, c;
  
  Circle(float xin, float yin) {
    x = xin;
    y = yin;
    size = 1;
    fill(255);
  }
  
  void update() {
    size ++;
  }
  
  void display() {
    circle(x, y, size);
  }
  
  boolean newOne() {
    if (size == 25) {
      return true;
    }
    else {
      return false;
    }
  }
}
