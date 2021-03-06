package com.raindrop;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

import javax.swing.*;

/**
 * @name: com.raindrop.SearchInBing.java
 * @description: Bing search
 * @author: Raindrop
 * @create Time: 2018/5/16 20:47
 */
public class SearchInBing extends AnAction {

    /**
     * Default Prefix
     */
    public static final String BING_SEARCH_PREFIX = "https://cn.bing.com/search?q=";

    public SearchInBing() {
        // Load icon
        super(null, null, new ImageIcon(SearchInBing.class.getClassLoader().getResource("icon/bing.png")));
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        // get editor
        final Editor editor = e.getData(PlatformDataKeys.EDITOR);
        // get select model
        SelectionModel selectionModel = editor.getSelectionModel();
        // get user selected text
        String text = selectionModel.getSelectedText();
        if (text != null && text.trim() != "") {
            // Open the browser
            BrowserUtil.browse(BING_SEARCH_PREFIX + text);
        } else {
            BrowserUtil.browse(BING_SEARCH_PREFIX);
        }
    }
}
