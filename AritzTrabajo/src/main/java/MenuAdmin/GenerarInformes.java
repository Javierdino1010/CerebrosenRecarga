package MenuAdmin;

import java.io.File;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;

public class GenerarInformes {

    public void exportarLibro(String tipoInforme) {
    	
    	if(tipoInforme.equals("Libros prestados")) {
    		tipoInforme = "ListaLibros";
    	}else if(tipoInforme.equals("Usuarios con mas libros")) {
    		tipoInforme = "UsuariosMasReservas";
    	}else if(tipoInforme.equals("Libros mas populares")) {
    		tipoInforme = "LibrosMasReservas";
    	}else if(tipoInforme.equals("Tendencias por genero")) {
    		tipoInforme = "GenerosPopulares";
    	}
    	
    	IReportEngine engine = null;
    	 
    	 try {
    		 // Configuración del motor BIRT
    		 EngineConfig config = new EngineConfig();
    		 Platform.startup(config);
    		 IReportEngineFactory factory = (IReportEngineFactory)Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
    	
    		 engine = factory.createReportEngine(config);

    		 String reportPath = "C:\\Users\\ikasle\\git\\CerebrosenRecargaMaven\\AritzTrabajo\\src\\main\\java\\reportes\\"+ tipoInforme +".rptdesign";
    		 
    		// Abre el informe
    		 IReportRunnable report = engine.openReportDesign(reportPath);
    		 // Crear tarea para ejecutar y renderizar
    		 IRunAndRenderTask task = engine.createRunAndRenderTask(report);
    		 
    		 String userHome = System.getProperty("user.home");
    		 String outputFilePath = userHome + "\\Desktop\\"+ tipoInforme +".pdf";

    		 HTMLRenderOption options = new HTMLRenderOption();
    		 options.setOutputFileName(outputFilePath);
    		 options.setOutputFormat("pdf");

    		 task.setRenderOption(options);
    		 // Ejecutar para crear el archivo HTML
    		 task.run();
    		 // Ahora finalizamos la tarea
    		 task.close();
    		 
    		 File htmlFile = new File(outputFilePath);
    		 } catch (Exception e) {
    		 e.printStackTrace();
    		 }finally {
    			  if (engine != null) {
    				  engine.destroy();
    			  }
    			  	  Platform.shutdown();
    			  }
    }
}
