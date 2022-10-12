package com.example.application.views.chart;

import com.example.application.views.MainLayout;
import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.TitleSubtitle;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.builder.LegendBuilder;
import com.github.appreciated.apexcharts.config.builder.ResponsiveBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.legend.Position;
import com.github.appreciated.apexcharts.config.responsive.builder.OptionsBuilder;
import com.github.appreciated.apexcharts.config.subtitle.Align;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Hello Piechart")
@Route(value = "pie", layout = MainLayout.class)
public class PieChartView extends VerticalLayout {
    private static final String[] COLOR_CODES = { "#00aedb", "#c663ff", "#f47835", "#d41243", "#8ec127",
            "#7fd6ed", "#ffeb66", "#f8ae85", "#e5708e", "#bbd97d", "#006883", "#610099", "#92481f",
            "#7f0a28", "#557317" };

    public PieChartView() {
        add(new H1("Heading"));
        ApexCharts chart = initializeDefaultChart();
        TitleSubtitle chartTitle = new TitleSubtitle();
        chartTitle.setText("Company growth");
        chartTitle.setAlign(Align.CENTER);
        chart.setTitle(chartTitle);
        chart.updateSeries(Double.valueOf(95), Double.valueOf(60), Double.valueOf(55), Double.valueOf(88));
        chart.setLabels("Q1", "Q2", "Q3", "Q4");
        chart.resetSeries(Boolean.TRUE, Boolean.TRUE);
        // FIXME problematic:
        chart.setSizeFull();
        // Not the correct workaround:
        // chart.setHeight(500, Unit.PIXELS);
        add(chart);
        add(new H1("Footer"));
        setSizeFull();
    }

    private static ApexCharts initializeDefaultChart() {
        return ApexChartsBuilder.get().withChart(ChartBuilder.get().withType(Type.PIE).build())
                .withLegend(LegendBuilder.get().withPosition(Position.RIGHT).build())
                .withSeries(Double.valueOf(0))
                .withResponsive(ResponsiveBuilder.get().withBreakpoint(Double.valueOf(480.0))
                        .withOptions(OptionsBuilder.get()
                                .withLegend(LegendBuilder.get().withPosition(Position.BOTTOM).build())
                                .build())
                        .build())
                .withColors(COLOR_CODES).build();
    }
}
