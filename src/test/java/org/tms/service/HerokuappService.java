package org.tms.service;

import org.tms.page.ContextMenuPage;
import org.tms.page.DynamicControlsPage;
import org.tms.page.FileUploaderPage;

public class HerokuappService {

    private static final String CONTEXT_MENU_URL = "http://the-internet.herokuapp.com/context_menu";
    private static final String DYNAMIC_CONTROLS_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    private static final String FILE_UPLOADER_URL = "http://the-internet.herokuapp.com/upload";

    private ContextMenuPage contextMenuPage = new ContextMenuPage();
    private DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    private FileUploaderPage fileUploaderPage = new FileUploaderPage();

    public ContextMenuPage openPageContextMenu(){
        contextMenuPage.openPage(CONTEXT_MENU_URL);
        return new ContextMenuPage();
    }
    public DynamicControlsPage openPageDynamicControls(){
        dynamicControlsPage.openPage(DYNAMIC_CONTROLS_URL);
        return new DynamicControlsPage();
    }
    public FileUploaderPage openPageFileUploader(){
        fileUploaderPage.openPage(FILE_UPLOADER_URL);
        return new FileUploaderPage();
    }
}


