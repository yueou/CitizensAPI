package net.citizensnpcs.api.npc;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

/**
 * Controls the registration and lookup of a set of {@link NPC}s.
 */
public interface NPCRegistry extends Iterable<NPC> {

    /**
     * Creates an despawned {@link NPC}.
     * 
     * @param type
     *            {@link EntityType} to assign to the NPC
     * @param name
     *            Name to give the NPC
     * @return Created NPC
     */
    public NPC createNPC(EntityType type, String name);

    /**
     * Deregisters the {@link NPC} and removes all data about it from the data
     * store.
     * 
     * @param npc
     */
    public void deregister(NPC npc);

    /**
     * Deregisters all {@link NPC}s from this registry. {@link #deregister(NPC)}
     */
    public void deregisterAll();

    /**
     * Gets the {@link NPC} with the given ID if it exists.
     * 
     * @param id
     *            ID of the NPC
     * @return NPC with the given ID (may or may not be spawned)
     */
    public NPC getById(int id);

    /**
     * Tries to convert the given {@link Entity} to a spawned {@link NPC}.
     * 
     * @param entity
     *            Entity to get the NPC from
     * @return NPC from the given entity or null if not found.
     */
    public NPC getNPC(Entity entity);

    /**
     * Checks whether the given {@link Entity} is convertable to an {@link NPC}.
     * 
     * @param entity
     *            Entity to check
     * @return Whether the given entity is an NPC
     */
    public boolean isNPC(Entity entity);
}