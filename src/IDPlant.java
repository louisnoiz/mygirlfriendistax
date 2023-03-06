
import java.awt.*;
import javax.swing.*;

public class IDPlant {

    private Image dead = new ImageIcon("photo/Seed/dead.png").getImage();

    // 1
    private Image corn1 = new ImageIcon("photo/Seed/corn1.png").getImage();
    private Image corn2 = new ImageIcon("photo/Seed/corn2.png").getImage();
    private Image corn3 = new ImageIcon("photo/Seed/corn3.png").getImage();
    private Image corn1w = new ImageIcon("photo/Seed/cornwet1.png").getImage();
    private Image corn2w = new ImageIcon("photo/Seed/cornwet2.png").getImage();
    private Image corn3w = new ImageIcon("photo/Seed/cornwet3.png").getImage();

    // 2 
    private Image radish1 = new ImageIcon("photo/Seed/radish1.png").getImage();
    private Image radish2 = new ImageIcon("photo/Seed/radish2.png").getImage();
    private Image radish3 = new ImageIcon("photo/Seed/radish3.png").getImage();
    private Image radish1w = new ImageIcon("photo/Seed/radishwet1.png").getImage();
    private Image radish2w = new ImageIcon("photo/Seed/radishwet2.png").getImage();
    private Image radish3w = new ImageIcon("photo/Seed/radishwet3.png").getImage();

    // 3
    private Image pumkin1 = new ImageIcon("photo/Seed/pumkin1.png").getImage();
    private Image pumkin2 = new ImageIcon("photo/Seed/pumkin2.png").getImage();
    private Image pumkin3 = new ImageIcon("photo/Seed/pumkin3.png").getImage();
    private Image pumkin1w = new ImageIcon("photo/Seed/pumkinwet1.png").getImage();
    private Image pumkin2w = new ImageIcon("photo/Seed/pumkinwet2.png").getImage();
    private Image pumkin3w = new ImageIcon("photo/Seed/pumkinwet3.png").getImage();

    // 4
    private Image carrot1 = new ImageIcon("photo/Seed/carrot1.png").getImage();
    private Image carrot2 = new ImageIcon("photo/Seed/carrot2.png").getImage();
    private Image carrot3 = new ImageIcon("photo/Seed/carrot3.png").getImage();
    private Image carrot1w = new ImageIcon("photo/Seed/carrotwet1.png").getImage();
    private Image carrot2w = new ImageIcon("photo/Seed/carrotwet2.png").getImage();
    private Image carrot3w = new ImageIcon("photo/Seed/carrotwet3.png").getImage();

    // 5
    private Image strawberry1 = new ImageIcon("photo/Seed/strawberry1.png").getImage();
    private Image strawberry2 = new ImageIcon("photo/Seed/strawberry2.png").getImage();
    private Image strawberry3 = new ImageIcon("photo/Seed/strawberry3.png").getImage();
    private Image strawberry1w = new ImageIcon("photo/Seed/strawberrywet1.png").getImage();
    private Image strawberry2w = new ImageIcon("photo/Seed/strawberrywet2.png").getImage();
    private Image strawberry3w = new ImageIcon("photo/Seed/strawberrywet3.png").getImage();

    // 6
    private Image tomato1 = new ImageIcon("photo/Seed/tomato1.png").getImage();
    private Image tomato2 = new ImageIcon("photo/Seed/tomato2.png").getImage();
    private Image tomato3 = new ImageIcon("photo/Seed/tomato3.png").getImage();
    private Image tomato1w = new ImageIcon("photo/Seed/tomatowet1.png").getImage();
    private Image tomato2w = new ImageIcon("photo/Seed/tomatowet2.png").getImage();
    private Image tomato3w = new ImageIcon("photo/Seed/tomatowet3.png").getImage();

    private Image img;
    
    public Image getplant(Plant plant) {


        if (plant.getWater() == -2) {
            img = dead;
        } 
        else {
            //        id 1 : corn
            if (plant.getId() == 1) {
                if (plant.getState() == 1) {
                    if (plant.getWater() != 1) {
                        img = corn1;
                    } else {
                        img = corn1w;
                    }
                } else if (plant.getState() == 2) {
                    if (plant.getWater() != 1) {
                        img = corn2;
                    } else {
                        img = corn2w;
                    }
                } else if (plant.getState() == 3) {
                    if (plant.getWater() != 1) {
                        img = corn3;
                    } else {
                        img = corn3w;
                    }
                }

            } //        id 2 : radish
            else if (plant.getId() == 2) {
                if (plant.getState() == 1) {
                    if (plant.getWater() != 1) {
                        img = radish1;
                    } else {
                        img = radish1w;
                    }
                } else if (plant.getState() == 2) {
                    if (plant.getWater() != 1) {
                        img = radish2;
                    } else {
                        img = radish2w;
                    }
                } else if (plant.getState() == 3) {
                    if (plant.getWater() != 1) {
                        img = radish3;
                    } else {
                        img = radish3w;
                    }
                }
            } //        id 3 : pumkin
            else if (plant.getId() == 3) {
                if (plant.getState() == 1) {
                    if (plant.getWater() != 1) {
                        img = pumkin1;
                    } else {
                        img = pumkin1w;
                    }
                } else if (plant.getState() == 2) {
                    if (plant.getWater() != 1) {
                        img = pumkin2;
                    } else {
                        img = pumkin2w;
                    }
                } else if (plant.getState() == 3) {
                    if (plant.getWater() != 1) {
                        img = pumkin3;
                    } else {
                        img = pumkin3w;
                    }
                }
            } //        id 4 : carrot
            else if (plant.getId() == 4) {
                if (plant.getState() == 1) {
                    if (plant.getWater() != 1) {
                        img = carrot1;
                    } else {
                        img = carrot1w;
                    }
                } else if (plant.getState() == 2) {
                    if (plant.getWater() != 1) {
                        img = carrot2;
                    } else {
                        img = carrot2w;
                    }
                } else if (plant.getState() == 3) {
                    if (plant.getWater() != 1) {
                        img = carrot3;
                    } else {
                        img = carrot3w;
                    }
                }
            } //      id 5 : strawberry
            else if (plant.getId() == 5) {
                if (plant.getState() == 1) {
                    if (plant.getWater() != 1) {
                        img = strawberry1;
                    } else {
                        img = strawberry1w;
                    }
                } else if (plant.getState() == 2) {
                    if (plant.getWater() != 1) {
                        img = strawberry2;
                    } else {
                        img = strawberry2w;
                    }
                } else if (plant.getState() == 3) {
                    if (plant.getWater() != 1) {
                        img = strawberry3;
                    } else {
                        img = strawberry3w;
                    }
                }
            } //      id 6 : tomato
            else if (plant.getId() == 6) {
                if (plant.getState() == 1) {
                    if (plant.getWater() != 1) {
                        img = tomato1;
                    } else {
                        img = tomato1w;
                    }
                } else if (plant.getState() == 2) {
                    if (plant.getWater() != 1) {
                        img = tomato2;
                    } else {
                        img = tomato2w;
                    }
                } else if (plant.getState() == 3) {
                    if (plant.getWater() != 1) {
                        img = tomato3;
                    } else {
                        img = tomato3w;
                    }
                }
            }
        }
        return img;
    }
}
