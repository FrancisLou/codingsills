package org.codingsills.modules.metrics.reporter;

import java.util.Map;

import org.codingsills.modules.metrics.Counter;
import org.codingsills.modules.metrics.Gauge;
import org.codingsills.modules.metrics.Histogram;
import org.codingsills.modules.metrics.Timer;

/**
 * Reporter的公共接口，被ReportScheduler定时调用。
 * 
 */
public interface Reporter {

    void report(Map<String, Gauge> gauges, Map<String, Counter> counters,
            Map<String, Histogram> histograms, Map<String, Timer> timers);
}
