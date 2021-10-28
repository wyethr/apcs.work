
from math import *
from turtle import *


reset()
speed(5000)

bgcolor("black")

# big circle in middle of sun

penup();
goto(100, 0)
pendown();

color("white")

t = 0

while t <= 2*pi:
    r = 100;
    x = r*cos(t);
    y = r*sin(t);
    goto(x, y);
    t += 0.1;

# head design:

penup();
goto(25, 0);
pendown();

t = 0;

while t <= 2*pi:
    r = 25 + 50*sin(t);
    x = r*cos(t);
    y = r*sin(t);
    goto(x, y);
    t += 0.1;

# eyes:

t = 0;

penup();
goto(-60, -25);
pendown();

while t <= pi:
    r = 10;
    x = r*cos(t) - 70;
    y = r*sin(t) - 25;
    goto(x, y);
    t += 0.1;

t = 0;

penup();
goto(70, -25);
pendown();

while t <= pi:
    r = 10;
    x = r*cos(t) + 60;
    y = r*sin(t) - 25;
    goto(x, y);
    t += 0.1;

# mouth:

penup();
goto(5, -75);
pendown();

t = 0;

while t <= 2*pi:
    r = 5 + 5*sin(t);
    x = r*cos(t);
    y = r*sin(t) - 75;
    goto(x, y);
    t += 0.1;

# nose:

penup();
goto(0, -35);
pendown();

t = 0;
a = 5;

while t<= 2*pi:
    if (sin(2*t) < 0):
        r = -1*sqrt(-1*a*a*sin(2*t))
    else:
        r = sqrt(a*a*sin(2*t)); 
    x = r*cos(t);
    y = r*sin(t) - 35;
    goto(x, y);
    t += 0.1;

# dress

penup();
goto(101.66701599939773, -298.2903392266159);
pendown();

t = 0;

while t <= 2*pi:
    r = 100 + 100*sin(t)
    x = r*cos(t);
    y = r*sin(t) - 300;
    goto(x, y);
    t += 0.1;

# arms

penup();
goto(-75.0, -225.0);
pendown();

t = 0;

while t <= 2*pi:
    r = 25;
    x = 2*r*cos(t) - 125;
    y = r*sin(t) - 225;
    goto(x, y);
    t += 0.1

penup();
goto(175, -225);
pendown();

t = 0;

while t <= 2*pi:
    r = 25;
    x = 2*r*cos(t) + 125;
    y = r*sin(t) - 225;
    goto(x, y);
    t += 0.1

# legs

penup()
goto(-35, -325);
pendown();

t = 0;

while t <= 2*pi:
    r = 15;
    x = r*cos(t) - 50;
    y = 2*r*sin(t) - 325;
    goto(x, y);
    t += 0.1;

penup()
goto(65, -325);
pendown();

t = 0;

while t <= 2*pi:
    r = 15;
    x = r*cos(t) + 50;
    y = 2*r*sin(t) - 325;
    goto(x, y);
    t += 0.1;

# hair

penup();
goto(150, 0);
pendown();

t = 0;

while t <= pi:
    r = 150;
    x = r*cos(t);
    y = r*sin(t);
    goto(x, y);
    t += 0.1

right(90);
forward(105);
left(90);
forward(300);
left(90);
forward(100);

# halo

penup();
goto(100, 175);
pendown();

t = 0;

while t <= 2*pi:
    r = 40;
    x = 2.5*r*cos(t);
    y = 1/2*r*sin(t) + 175;
    goto(x, y);
    t += 0.1

# crossy-flower

penup()
goto(50.0, -200.0)
pendown()

t = 0;

while t<= 2*pi:
    r = 50*cos(2*t)
    x = r*cos(t);
    y = r*sin(t) - 200;
    goto(x, y);
    t += 0.1

penup();
goto(75, -200);
pendown();

# crossy-flower i decided to delete lol

# t = 0;
# a = 75;

# while t<= 2*pi:
#     if (a*a*cos(2*t) < 0):
#         r = sqrt(-1*a*a*cos(2*t))
#     else:
#         r = sqrt(a*a*cos(2*t));
#     x = r*cos(t);
#     y = r*sin(t) - 200;
#     goto(x, y);
#     t += 0.1;

# infinity

# MY BEAUTIFUL, BEAUTIFUL, SHOULD-BE WORKING SOLUTION TT WHY DOESN'T THIS WORK I LOVE IT SO MUCH 

# t = 0;

# while t<= 2*pi:
    # r = 50*cos(2*t)
    # x = r*cos(t);
    # y = r*sin(t);
    # while (t > pi/4 and t < 3*pi/4):
        # penup();
        # t += 0.1
    # 2hile (t > 5*pi/4 and t < 7*pi/4):
        # penup();
        # t += 0.1
    # pendown();
    # goto(x, y);
    # t += 0.1

penup()
goto(-275, 300)
pendown();

t = 0;
a = 25;

while t<= 2*pi:
    if (cos(2*t) < 0):
        goto(-300, 300);
        t+= 0.1;
    else:
        r = sqrt(a*a*cos(2*t)); 
        x = r*cos(t) - 300;
        y = r*sin(t) + 300;
        goto(x, y);
        t += 0.1;

# YES JFDKSLFJKDSL FINALLY IT WORKS

# words

penup()
goto(-250, 288.5)
pendown();

forward(25);
right(90);
forward(12.5);
right(90);
forward(25);

penup()
left(90);
forward(25);
pendown();

left(90);
forward(25);
left(180);
forward(25);
left(90);
forward(12.5);
left(90);
forward(25);

penup()
right(90)
forward(25)
pendown()

forward(6.25)
right(90)
forward(25)
backward(25)
left(90)
forward(6.25)

penup()
forward(25)
pendown()

right(90)
forward(25)
backward(25)
left(90)
forward(6.25)
right(90)
forward(25)
backward(25)
left(90)
forward(6.25)
right(90)
forward(25)

penup()
left(90)
forward(25)
pendown()

forward(12.5)
backward(12.5)
left(90)
forward(12.5)
right(90)
forward(12.5)
backward(12.5)
left(90)
forward(12.5)
right(90)
forward(12.5)

penup()
forward(25)
pendown()

right(90)
forward(25)
left(90)
forward(12.5)

penup()
forward(25)
forward(12.5)
pendown()

left(90)
forward(25)
left(90)
forward(6.25)
backward(12.5)
left(180)

penup()
forward(25)
pendown()

right(90)
forward(25)
backward(12.5)
left(90)
forward(12.5)
left(90)
forward(12.5)
backward(25)
right(90)

penup()
forward(25)
pendown()

forward(12.5)
backward(12.5)
left(90)
forward(12.5)
right(90)
forward(12.5)
backward(12.5)
left(90)
forward(12.5)
right(90)
forward(12.5)

penup()
forward(24)
pendown()

right(90)
forward(25)
backward(25)
left(90)
forward(12.5)
right(90)
forward(12.5)
right(90)
forward(12.5)
backward(12.5)
left(90)
forward(12.5)

penup()
left(90)
forward(25)
pendown()

left(90)
forward(25)
right(90);
forward(12.5);
right(90);
forward(25);

penup()
left(90)
forward(25)
pendown()

left(90)
forward(25)
right(90)
forward(12.5)
backward(12.5)
right(90)
forward(25)
left(90)
forward(12.5)
left(90)
forward(6.25)
left(90)
forward(6.25)
backward(12.5)

penup()
left(180)
forward(25)
right(90)
forward(6.25)
left(90)
pendown()

forward(12.5)
backward(12.5)
left(90)
forward(12.5)
right(90)
forward(12.5)
backward(12.5)
left(90)
forward(12.5)
right(90)
forward(12.5)

penup()
forward(25)
pendown()

right(90)
forward(25)
left(90)
forward(12.5)

penup()
forward(25)
pendown()

forward(5)
left(90)
forward(5)
left(90)
forward(5)
left(90)
forward(5)
penup()
backward(10)
left(90)
forward(3)
left(90)
pendown()
forward(15)

# getting pen off screen

penup()
forward(400)

done()
