package org.codingsills.modules.metrics.exporter;

import org.codingsills.modules.metrics.Counter;
import org.codingsills.modules.metrics.Gauge;
import org.codingsills.modules.metrics.Histogram;
import org.codingsills.modules.metrics.Timer;

public interface MetricRegistryListener {

	void onGaugeAdded(String name, Gauge gauge);

	void onCounterAdded(String name, Counter counter);

	void onHistogramAdded(String name, Histogram histogram);

	void onTimerAdded(String name, Timer timer);

	void onGaugeRemoved(String name);

	void onCounterRemoved(String name);

	void onHistogramRemoved(String name);

	void onTimerRemoved(String name);
}
