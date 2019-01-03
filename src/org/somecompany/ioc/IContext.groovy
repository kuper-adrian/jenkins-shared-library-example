package org.somecompany.ioc

import org.somecompany.IStepExecutor

interface IContext {
    IStepExecutor getStepExecutor()
}
