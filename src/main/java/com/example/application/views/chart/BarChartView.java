package com.example.application.views.chart;

import com.example.application.views.MainLayout;
import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.TitleSubtitle;
import com.github.appreciated.apexcharts.config.builder.ChartBuilder;
import com.github.appreciated.apexcharts.config.builder.DataLabelsBuilder;
import com.github.appreciated.apexcharts.config.builder.FillBuilder;
import com.github.appreciated.apexcharts.config.builder.PlotOptionsBuilder;
import com.github.appreciated.apexcharts.config.builder.StrokeBuilder;
import com.github.appreciated.apexcharts.config.builder.XAxisBuilder;
import com.github.appreciated.apexcharts.config.builder.YAxisBuilder;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.plotoptions.builder.BarBuilder;
import com.github.appreciated.apexcharts.config.subtitle.Align;
import com.github.appreciated.apexcharts.config.yaxis.builder.TitleBuilder;
import com.github.appreciated.apexcharts.helper.Series;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Hello Barchart")
@Route(value = "bar", layout = MainLayout.class)
public class BarChartView extends VerticalLayout {
    private static final String[] COLOR_CODES = { "#00aedb", "#c663ff", "#f47835", "#d41243", "#8ec127",
            "#7fd6ed", "#ffeb66", "#f8ae85", "#e5708e", "#bbd97d", "#006883", "#610099", "#92481f",
            "#7f0a28", "#557317" };

    public BarChartView() {
        add(new H1("Heading"));
        ApexCharts chart = initializeDefaultChart();
        TitleSubtitle chartTitle = new TitleSubtitle();
        chartTitle.setText("Company growth");
        chartTitle.setAlign(Align.CENTER);
        chart.setTitle(chartTitle);
        chart.updateSeries(
                new Series<>("2010", Double.valueOf(100), Double.valueOf(20), Double.valueOf(80),
                        Double.valueOf(50)),
                new Series<>("2011", Double.valueOf(95), Double.valueOf(60), Double.valueOf(55),
                        Double.valueOf(88)));
        chart.setLabels("Q1", "Q2", "Q3", "Q4");
        chart.resetSeries(Boolean.TRUE, Boolean.TRUE);
        chart.setSizeFull();
        add(chart);
        add(new H1("Footer"));
        setSizeFull();
    }

    private static ApexCharts initializeDefaultChart() {
        return ApexChartsBuilder.get().withChart(ChartBuilder.get().withType(Type.BAR).build())
                .withPlotOptions(PlotOptionsBuilder.get()
                        .withBar(BarBuilder.get().withHorizontal(Boolean.FALSE).withColumnWidth("55%")
                                .withDistributed(Boolean.TRUE).build())
                        .build())
                .withDataLabels(DataLabelsBuilder.get().withEnabled(Boolean.TRUE).build())
                .withStroke(StrokeBuilder.get().withShow(Boolean.TRUE).withWidth(Double.valueOf(2.0))
                        .withColors("transparent").build())
                .withSeries(new Series<>("Empty", Double.valueOf(0)))
                .withYaxis(
                        YAxisBuilder.get().withTitle(TitleBuilder.get().withText("Summe").build()).build())
                .withXaxis(XAxisBuilder.get().build())
                .withFill(FillBuilder.get().withOpacity(Double.valueOf(1.0)).build())
                .withColors(COLOR_CODES).build();
    }
}
