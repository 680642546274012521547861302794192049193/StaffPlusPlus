package net.shortninja.staffplus.core.domain.player.listeners;

import be.garagepoort.mcioc.IocBean;
import net.shortninja.staffplus.core.StaffPlus;
import net.shortninja.staffplus.core.common.config.Options;
import net.shortninja.staffplus.core.domain.staff.tracing.TraceService;
import net.shortninja.staffplus.core.session.SessionManagerImpl;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

import static net.shortninja.staffplus.core.domain.staff.tracing.TraceType.PICKUP_ITEM;

@IocBean
public class PlayerPickupItem implements Listener {
    private final Options options;
    private final TraceService traceService;
    private final SessionManagerImpl sessionManager;

    public PlayerPickupItem(Options options, TraceService traceService, SessionManagerImpl sessionManager) {
        this.options = options;
        this.traceService = traceService;
        this.sessionManager = sessionManager;
        Bukkit.getPluginManager().registerEvents(this, StaffPlus.get());
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPickup(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            if (options.modeConfiguration.isModeItemPickup() || !sessionManager.get(player.getUniqueId()).isInStaffMode()) {
                traceService.sendTraceMessage(PICKUP_ITEM, player.getUniqueId(), String.format("Picked up item [%s]", event.getItem().getItemStack().getType()));
                return;
            }
            event.setCancelled(true);
        }

    }
}