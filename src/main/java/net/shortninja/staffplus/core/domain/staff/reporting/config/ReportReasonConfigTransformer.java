package net.shortninja.staffplus.core.domain.staff.reporting.config;

import be.garagepoort.mcioc.configuration.IConfigTransformer;
import net.shortninja.staffplus.core.application.config.ConfigurationUtil;
import org.bukkit.Material;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReportReasonConfigTransformer implements IConfigTransformer<List<ReportReasonConfiguration>, List<LinkedHashMap<String, String>>> {
    @Override
    public List<ReportReasonConfiguration> mapConfig(List<LinkedHashMap<String, String>> list) {
        if(list == null) {
            return Collections.emptyList();
        }

        return Objects.requireNonNull(list).stream().map(map -> {
            String reason = map.get("reason");
            String type = map.get("type");
            String lore = map.get("info");
            Material material = map.containsKey("material") ? Material.valueOf(map.get("material")) : Material.PAPER;
            String filtersString = map.containsKey("filters") ? map.get("filters") : null;
            Map<String, String> filterMap = ConfigurationUtil.loadFilters(filtersString);
            return new ReportReasonConfiguration(reason, type, material, lore, filterMap);
        }).collect(Collectors.toList());
    }
}