@echo on
@echo =============================================================
@echo $                                                           $
@echo $                     Nepxion Signature                     $
@echo $                                                           $
@echo $                                                           $
@echo $                                                           $
@echo $  Nepxion Technologies All Right Reserved                  $
@echo $  Copyright(C) 2010                                        $
@echo $                                                           $
@echo =============================================================
@echo.
@echo off

@title Nepxion Signature
@color 0a

jarsigner -keystore security.store ../lib/swing/alloy-skin-1.4.4.jar security
jarsigner -keystore security.store ../lib/swing/borland-skin-2006.jar security
jarsigner -keystore security.store ../lib/swing/itext-2.1.7.jar security
jarsigner -keystore security.store ../lib/swing/itext-asian.jar security
jarsigner -keystore security.store ../lib/swing/jcommon-1.0.16.jar security
jarsigner -keystore security.store ../lib/swing/jdesktop-swing-worker-1.2.jar security
jarsigner -keystore security.store ../lib/swing/jdesktop-swingx-1.6.1.jar security
jarsigner -keystore security.store ../lib/swing/jfreechart-1.0.13.jar security
jarsigner -keystore security.store ../lib/swing/jfreechart-1.0.13-experimental.jar security
jarsigner -keystore security.store ../lib/swing/jgoodies-forms-1.3.0.jar security
jarsigner -keystore security.store ../lib/swing/jgoodies-skin-2.1.4.jar security
jarsigner -keystore security.store ../lib/swing/jide-oss-2.9.5.jar security
jarsigner -keystore security.store ../lib/swing/l2fprod-common-all-7.3.jar security
jarsigner -keystore security.store ../lib/swing/native-skin-6.7.jar security
jarsigner -keystore security.store ../lib/swing/plugin.jar security
jarsigner -keystore security.store ../lib/swing/tiny-skin.jar security
jarsigner -keystore security.store ../lib/swing/trayIcon-1.7.9B.jar security
jarsigner -keystore security.store ../lib/swing/vldocking-2.1.5.jar security
jarsigner -keystore security.store ../lib/swing/xp-skin.jar security