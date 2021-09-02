Circle circle;
ArrayList<Circle> circles;
ArrayList<Circle> extracircles;

void setup() {
  size(400, 400);
  background(255);

  circle = new Circle(width/2, height/2);
  circles = new ArrayList<Circle>();
  extracircles = new ArrayList<Circle>();
  circles.add(circle);
}

void draw() {

  for (int i = circles.size()-1; i > -1; i--) {
    Circle d = circles.get(i);

    if (d.newOne()) {
      Circle e = new Circle(width/2, height/2);
      circles.add(e);
    }
  }
  
  for (Circle c : circles) {
    c.update();
    c.display();
  }

  for (Circle c : extracircles) {
    c.update();
    c.display();
  }
}

void keyPressed() {
  Circle f = new Circle(width/2, height/2);
  extracircles.add(f);
}
