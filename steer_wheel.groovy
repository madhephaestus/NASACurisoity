import com.neuronrobotics.bowlerstudio.creature.ICadGenerator;
import com.neuronrobotics.bowlerstudio.creature.CreatureLab;
import org.apache.commons.io.IOUtils;
import com.neuronrobotics.bowlerstudio.vitamins.*;
import java.nio.file.Paths;
import eu.mihosoft.vrl.v3d.FileUtil;
import com.neuronrobotics.bowlerstudio.vitamins.*;
println "Loading STL file"
// Load an STL file from a git repo
// Loading a local file also works here

return new ICadGenerator(){
	@Override 
	public ArrayList<CSG> generateCad(DHParameterKinematics d, int linkIndex) {
		ArrayList<DHLink> dhLinks = d.getChain().getLinks()
		ArrayList<CSG> allCad=new ArrayList<CSG>()
		int i=linkIndex;
		DHLink dh = dhLinks.get(linkIndex)
		// Hardware to engineering units configuration
		LinkConfiguration conf = d.getLinkConfiguration(i);
		// Engineering units to kinematics link (limits and hardware type abstraction)
		AbstractLink abstractLink = d.getAbstractLink(i);// Transform used by the UI to render the location of the object
		// Transform used by the UI to render the location of the object
		Affine manipulator = dh.getListener();

		if (i==0){
			
			File steer_file = ScriptingEngine.fileFromGit(
			"https://github.com/NeuronRobotics/NASACurisoity.git",
			"STL/steering-bracket.STL");
			CSG steer = Vitamins.get(steer_file)

			steer.setManipulator(manipulator)
			allCad.add(steer)
	
		}
		if (i==1){
			File wheel_file = ScriptingEngine.fileFromGit(
			"https://github.com/NeuronRobotics/NASACurisoity.git",
			"STL/wheel.STL");
			File tire_file = ScriptingEngine.fileFromGit(
			"https://github.com/NeuronRobotics/NASACurisoity.git",
			"STL/tire.STL");
			/*
			CSG wheel = Vitamins.get(wheel_file)
			wheel=wheel			
					.movex(-wheel.getMaxX()/2)
					.movey(-wheel.getMaxY()/2)
					.movez(-wheel.getMaxZ()/2)
					.rotx(90)
			wheel.setManipulator(manipulator)
			
			allCad.add(wheel)
			*/
			CSG tire = Vitamins.get(tire_file)

			tire.setManipulator(manipulator)

			allCad.add(tire)
		}
		return allCad;
	}
	@Override 
	public ArrayList<CSG> generateBody(MobileBase b ) {return new ArrayList<>();}
};
