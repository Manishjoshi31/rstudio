package org.rstudio.studio.client.projects.ui.vcs;

import org.rstudio.core.client.widget.ModalDialog;
import org.rstudio.core.client.widget.OperationWithInput;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import org.rstudio.studio.client.common.vcs.VCSServerOperations;
import org.rstudio.studio.client.server.Void;

public class ProjectVCSSetupDialog extends ModalDialog<Void>
{
   public ProjectVCSSetupDialog(VCSServerOperations server,
                                String defaultSshKeyDir)
   {
      super("Project Source Control Setup", new OperationWithInput<Void>() {
         @Override
         public void execute(Void input)
         {
            
         }
      });
      
      server_ = server;
      defaultSshKeyDir_ = defaultSshKeyDir;
   }

   @Override
   protected Void collectInput()
   {
      return null;
   }

   @Override
   protected boolean validate(Void input)
   {
      return true;
   }

   @Override
   protected Widget createMainWidget()
   {
      VerticalPanel panel = new VerticalPanel();
      panel.addStyleName(RES.styles().mainWidget());
      
      // TODO: this may not be the correct wat to handle a progress indicator
      // specifically, is it OK to call addProgressIndicator more than one
      // time? Perhpas this dialog should inherit from ModalDialogBase?
      
      /*
      SshKeyChooser keyChooser = new SshKeyChooser(server_, 
                                                   defaultSshKeyDir_, 
                                                   "250px",
                                                   addProgressIndicator(false));
     
      
      panel.add(keyChooser);
      */
      
      panel.add(new Label("Under Constsruction"));
      
      return panel;
      
   }

   
   static interface Styles extends CssResource
   {
      String mainWidget();
   }
  
   static interface Resources extends ClientBundle
   {
      @Source("ProjectVCSSetupDialog.css")
      Styles styles();
   }
   
   static Resources RES = (Resources)GWT.create(Resources.class) ;
   public static void ensureStylesInjected()
   {
      RES.styles().ensureInjected();
   }
   
   @SuppressWarnings("unused")
   private final VCSServerOperations server_;
   @SuppressWarnings("unused")
   private final String defaultSshKeyDir_;
}
