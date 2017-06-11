package lapr4.blue.s2.ipc.n1141233.importexportlink;

import csheets.core.Cell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Temporary Storage to store active links
 *
 * @author Rafael Vieira
 */
public class LinkStorage
{

    private static final Map<String, Link> TMP_MAP = new HashMap<>();

    private LinkStorage()
    {
    }

    public static boolean exists(String link)
    {
        return TMP_MAP.containsKey(link);
    }

    public static void add(Link link)
    {
        TMP_MAP.put(link.toString(), link);
    }

    public static void clear()
    {
        TMP_MAP.clear();
    }

    public static Iterable<Link> getAll()
    {
        return TMP_MAP.values();
    }

    public static Iterable<Link> getImports()
    {
        List<Link> list = new ArrayList<>();
        for (Link link : TMP_MAP.values())
        {
            if (link instanceof ImportLinkRunnable)
            {
                list.add(link);
            }
        }
        return list;
    }

    public static Iterable<Link> getExports()
    {
        List<Link> list = new ArrayList<>();
        for (Link link : TMP_MAP.values())
        {
            if (link instanceof ExportLinkListener)
            {
                list.add(link);
            }
        }
        return list;
    }

    /**
     * Deactivates a link and removes it from storage
     *
     * @param link link to be deactivated
     *
     * @return true if link was removed or false otherwise
     */
    public static boolean deactivateLink(Link link)
    {
        if (link instanceof ExportLinkListener)
        {
            stopExport((ExportLinkListener) link);
        }
        else if (link instanceof ImportLinkRunnable)
        {
            stopImport((ImportLinkRunnable) link);
        }
        return TMP_MAP.remove(link.toString(), link);
    }

    //stop links
    private static void stopExport(ExportLinkListener link)
    {
        for (Cell[] cellRow : link.getSelectedCells())
        {
            for (Cell cell : cellRow)
            {
                cell.removeCellListener(link);
            }
        }
    }

    private static void stopImport(ImportLinkRunnable link)
    {
        link.stop();
    }
}
