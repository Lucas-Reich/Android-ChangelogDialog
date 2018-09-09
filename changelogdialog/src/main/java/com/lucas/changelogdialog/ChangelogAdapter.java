package com.lucas.changelogdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ChangelogAdapter extends ArrayAdapter<Release> {

    private static class ViewHolder {
        TextView releaseVersion;
        TextView releaseDescription;
        LinearLayout releaseItems;
    }

    public ChangelogAdapter(List<Release> data, Context context) {
        super(context, R.layout.changelog_item, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Release release = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.changelog_item, parent, false);

            viewHolder.releaseVersion = convertView.findViewById(R.id.changelog_header_version);
            viewHolder.releaseDescription = convertView.findViewById(R.id.changelog_header_description);
            viewHolder.releaseItems = convertView.findViewById(R.id.changelog_item_row_container);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.releaseDescription.setVisibility(View.VISIBLE);
            viewHolder.releaseItems.removeAllViews();
        }

        viewHolder.releaseVersion.setText(release.getReleaseVersion());
        if (release.getReleaseDescription().equals("")) {

            viewHolder.releaseDescription.setVisibility(View.GONE);
        } else {

            viewHolder.releaseDescription.setText(release.getReleaseDescription());
        }

        for (ChangelogItem item : release.getItems()) {
            viewHolder.releaseItems.addView(getRow(item));
        }

        return convertView;
    }

    private View getRow(ChangelogItem rowItem) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.changelog_row, null);

        TextView rowType = view.findViewById(R.id.changelog_row_type);
        rowType.setText(String.format("- %s: ", rowItem.getType()));

        TextView rowDescription = view.findViewById(R.id.changelog_row_description);
        rowDescription.setText(rowItem.getDescription());

        return view;
    }
}
