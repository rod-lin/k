package org.kframework.keq;


import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParametersDelegate;
import org.kframework.main.GlobalOptions;
import org.kframework.unparser.PrintOptions;
import org.kframework.utils.inject.RequestScoped;
import org.kframework.utils.options.DefinitionLoadingOptions;
import org.kframework.utils.options.SMTOptions;

import java.util.Collections;
import java.util.List;

@RequestScoped
public final class KEqOptions {
    @ParametersDelegate
    public transient GlobalOptions global = new GlobalOptions();

    @ParametersDelegate
    public DefinitionLoadingOptions definitionLoading = new DefinitionLoadingOptions();

    @ParametersDelegate
    public SMTOptions smt = new SMTOptions();

    @ParametersDelegate
    public PrintOptions print = new PrintOptions();

    @Parameter(names={"--definition1", "-d1"}, description="Path to the directory in which the first kompiled " +
            "K definition resides. The default is the unique, only directory with the suffix '-kompiled' " +
            "in the current directory.")
    public String def1;


    @Parameter(names={"--definition2", "-d2"}, description="Path to the directory in which the second kompiled " +
            "K definition resides. The default is the unique, only directory with the suffix '-kompiled' " +
            "in the current directory.")
    public String def2;

    @Parameter(names={"--spec1", "-s1"}, description="Path to specification for first program.")
    public String spec1;

    @Parameter(names={"--spec2", "-s2"}, description="Path to specification for second program.")
    public String spec2;

    @Parameter(names={"--spec-module1", "-sm1"}, description="Name of module containing first specification to prove.")
    public String specModule1;

    @Parameter(names={"--spec-module2", "-sm2"}, description="Name of module containing second specification to prove.")
    public String specModule2;

    @Parameter(names={"--def-module1", "-m1"}, description="Name of module in first definition to use as definition.")
    public String defModule1;

    @Parameter(names={"--def-module2", "-m2"}, description="Name of module in second definition to use as definition.")
    public String defModule2;

    @Parameter(names={"--matching-prelude"}, description="Additional prelude used in matching nodes from both sides")
    public String matchingPrelude;

    @Parameter(names={"--show-traces"}, description="Show traces of symbolic rewriting")
    public boolean showTraces;

    @Parameter(names={"--show-smt"}, description="Show detailed SMT log")
    public boolean showSMT;

    @Parameter(names={"--parallel"}, description="Number of parallel jobs (min 1)")
    public int parallel = 1;

    @Parameter(names={"--mem-monitor-interval"}, description="Interval for memory monitor in milliseconds")
    public long memMonitorInterval = 2000;

    @Parameter(names={"--no-parser-cache"}, description="Do not cache parsing result")
    public boolean noParseCache;

    @Parameter(names={"--z3-query-log-dir"}, description="Directory to store all z3 queries made and their output")
    public String z3QueryLogDir;

    @Parameter(names={"--bisimulation"}, description="test for strict bisimulation instead of simulation (i.e. no error states)")
    public boolean bisimultion;

    @Parameter(names={"--disable-parallel-parsing"}, description="disable parallel parsing. it can reduce memory usage but may slow down the parsing (significantly)")
    public boolean disableParallelParsing;

//    @Parameter(names = "--boundary-cells1", description = "The comma-separated list of cells used to mark the boundary " +
//            "of evaluation. If option is specified, execution ends when these cells in the current term match same " +
//            "cells in the target term. (Except for step 1, for which boundary checking is disabled.)" +
//            "If the whole current term matches target, execution is successful. " +
//            "Otherwise it fails on the present path. If option is not specified, full target term implication is checked " +
//            "on every step. In most specifications boundary is marked by \"k\".")
//    public List<String> boundaryCells1 = Collections.emptyList();
//
//    @Parameter(names = "--boundary-cells2", description = "Same as --boundary-cells1 but for the second def module")
//    public List<String> boundaryCells2 = Collections.emptyList();
}