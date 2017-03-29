package com.catpaw.plugins.extensions;

/**
 * Created by congtaowang 2017/3/27.
 */

class Configurator {

    def File archiveDirectory
    def final PgyerExtension pgyerInst = new PgyerExtension()
    def final BnhExtension bnhInst = new BnhExtension()

    def pgyer(Closure closure){
        closure.delegate = pgyerInst
        closure.directive = Closure.DELEGATE_FIRST
        closure()
    }

    def bnh(Closure closure){
        closure.delegate = bnhInst
        closure.directive = Closure.DELEGATE_FIRST
        closure()
    }
}
