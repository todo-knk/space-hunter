package com.jfsaaved.libgdxgamejam15.options;

import com.badlogic.gdx.graphics.Color;
import com.jfsaaved.libgdxgamejam15.states.PlanetState;
import com.jfsaaved.libgdxgamejam15.states.ShipState;
import com.jfsaaved.libgdxgamejam15.ui.MenuImages;

/**
 * Created by 343076 on 13/01/2016.
 */
public class ShipOptions extends Options {

    private ShipState state;

    public ShipOptions(ShipState state){
        super();
        this.state = state;
    }

    @Override
    public void handleInput(){
        if(currentOption.elementAt(0) == 0)
            navigateOptions();
        else if(currentOption.elementAt(0) == 1)
            suppliesOptions();
        else if(currentOption.elementAt(0) == 2)
            maintenanceOptions();

        if(currentOption.empty()){
            state.statusImages.resetColorAll();

            String[] dialogue = {"Navigate through out the galaxy to different systems."};
            state.dialogueImages.setDialogues(dialogue);

            String[] options = {"NAVIGATE","HERO","SHIP","LAND","OPTIONS"};
            state.menuImages = new MenuImages(state.getCam(), options);
        }
    }

    @Override
    // Explains options through the dialogue box
    public void setHoverDesc(int i){
        if(currentOption.empty()){
            if(i == 0) {
                String[] dialogue = {"Navigate through out the galaxy to different systems."};
                state.dialogueImages.setDialogues(dialogue);
            }
            else if(i == 1) {
                String[] dialogue = {"Options to maintain the hero."};
                state.dialogueImages.setDialogues(dialogue);
            }
            else if(i == 2) {
                String[] dialogue = {"Options to maintain the ship."};
                state.dialogueImages.setDialogues(dialogue);
            }
            else if(i == 3) {
                String[] dialogue = {"Land at a habitable planet in this system."};
                state.dialogueImages.setDialogues(dialogue);
            }
            else if(i == 4) {
                String[] dialogue = {"Change the settings."};
                state.dialogueImages.setDialogues(dialogue);
            }
        }
        else if(currentOption.get(0) == 0) { // System explanations
            if(i == 0) {
                String[] dialogue = {"A system that has many exotic places, ready to be explored."};
                state.dialogueImages.setDialogues(dialogue);
            }
            else if(i == 1) {
                String[] dialogue = {"This system is where the planet Earth resides."};
                state.dialogueImages.setDialogues(dialogue);
            }
            else if(i == 2) {
                String[] dialogue = {"A system that has been abandoned by the government."};
                state.dialogueImages.setDialogues(dialogue);
            }
            else if(i == 3) {
                String[] dialogue = {"A hostile system, not well known to many."};
                state.dialogueImages.setDialogues(dialogue);
            }
            else if(i == 4) {
                String[] dialogue = {"Go back."};
                state.dialogueImages.setDialogues(dialogue);
            }
        }
        // health = 1, hunger = 2, energy = 3, hunter = 4, explorer = 5, mechanic = 6, shealth = 8, sfuel = 9, slevel = 10;
        else if(currentOption.get(0) == 1) { // Hero options
            if(i == 0) {
                state.statusImages.resetColorAll();
                state.statusImages.changeColourAt(Color.GREEN,2);
            }
            else if(i == 1) {
                state.statusImages.resetColorAll();
                state.statusImages.changeColourAt(Color.GREEN,1);
            }
            else if(i == 2) {
                state.statusImages.resetColorAll();
                state.statusImages.changeColourAt(Color.GREEN,3);
            }
            else {
                state.statusImages.resetColorAll();
            }
        }
    }

    private void navigateOptions(){
        String[] options = {"SYSTEM 1","SYSTEM 2","SYSTEM 3","SYSTEM 4","BACK"};
        state.menuImages = new MenuImages(state.getCam(), options);
        if(currentOption.size() > 1){
            if(currentOption.elementAt(1) == 0){
                state.changeTo(new PlanetState(state.getGSM()));
            }
            else if(currentOption.elementAt(1) == 1){
                state.changeTo(new PlanetState(state.getGSM()));
            }
            else if(currentOption.elementAt(1) == 2){
                state.changeTo(new PlanetState(state.getGSM()));
            }
            else if(currentOption.elementAt(1) == 3){
                state.changeTo(new PlanetState(state.getGSM()));
            }
            else if(currentOption.elementAt(1) == 4){
                currentOption.clear();
            }
        }
    }

    private void suppliesOptions(){
        String[] options = {"EAT","SLEEP","RELAX","BACK"};
        state.menuImages = new MenuImages(state.getCam(), options);
        if(currentOption.size() > 1){
            if(currentOption.elementAt(1) == 0){
                state.hero.setHunger(state.hero.getHunger() + 1);
                currentOption.clear();
            }
            else if(currentOption.elementAt(1) == 1){
                state.hero.setHealth(state.hero.getHealth() + 1);
                currentOption.clear();
            }
            else if(currentOption.elementAt(1) == 2){
                state.hero.setEnergy(state.hero.getEnergy() + 1);
                currentOption.clear();
            }
            else if(currentOption.elementAt(1) == 3){
                currentOption.clear();
            }
        }
    }

    private void maintenanceOptions(){
        String[] options = {"CLEAN","REPAIR","BACK"};
        state.menuImages = new MenuImages(state.getCam(), options);
        if(currentOption.size() > 1){
            if(currentOption.elementAt(1) == 0){
                state.ship.setFuel(state.ship.getFuel() + 1);
                currentOption.clear();
            }
            else if(currentOption.elementAt(1) == 1){
                state.ship.setHealth(state.ship.getHealth() + 1);
                currentOption.clear();
            }
            else if(currentOption.elementAt(1) == 2){
                currentOption.clear();
            }
        }
    }

}
