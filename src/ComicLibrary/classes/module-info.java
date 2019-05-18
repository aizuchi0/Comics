/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
module ComicLibrary {
    requires java.logging;
    requires java.xml.bind;
    exports xyz.aizuchi.comicrack;
    exports xyz.aizuchi.comicutility;
    opens xyz.aizuchi.comicrack;
}
