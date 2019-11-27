import robocode.*;

/**
 * DragaoCatiorroFalante - a robot by Guilherme
 */
public class DragaoCatiorroFalante extends AdvancedRobot
{
 
 boolean detected;
 
 boolean direction;

 public void run() {

  while(true) {
  
   
   if (!detected) {
    turnGunRight(180);
   } else {
    turnGunLeft(180);
    detected = false;
   } 
   
  }
 }


 public void onScannedRobot(ScannedRobotEvent e) {
 
  fire(3);  
  double angleToEnemy = e.getBearing();
  if (e.getDistance() > 250) {
   turnRight(angleToEnemy);
   ahead(150);
  } else if (angleToEnemy > 45 || angleToEnemy < -45){
   turnRight(90 - angleToEnemy);
   if (direction) {
    ahead(30);
   } else {
    back(30);
   }
   direction = !direction;
  }
 
    
  detected = true;
  
 }


 public void onHitByBullet(HitByBulletEvent e) {
 
  turnRight(45);
  ahead(100);
 }
 

 public void onHitWall(HitWallEvent e) {
  
  back(20);
 } 
}

