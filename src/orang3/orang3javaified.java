package orang3;
import mindustry.world.meta.Env;
import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class orang3javaified extends Mod{
//defense
    Block leadWall;
    public orang3javaified(){
        Log.info("Loaded orang3javaified constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    
    @Override
    public void loadContent(){
        Log.info("Loading some example content.");
        //region defense

        int wallHealthMultiplier = 4;

        leadWall = new Wall("lead-wall"){{
            requirements(Category.defense, with(Items.lead, 6));
            health = 85 * wallHealthMultiplier;
            researchCostMultiplier = 0.1f;
            envDisabled |= Env.scorching;
        }}; 
    }

}



